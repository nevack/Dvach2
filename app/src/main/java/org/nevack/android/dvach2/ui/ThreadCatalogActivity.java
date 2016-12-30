package org.nevack.android.dvach2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.nevack.android.dvach2.DvachService;
import org.nevack.android.dvach2.R;
import org.nevack.android.dvach2.model.BoardSimplified;
import org.nevack.android.dvach2.model.ThreadSimplified;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThreadCatalogActivity extends AppCompatActivity {

    private static final String BOARD_EXTRA = "boardcode";
    private String boardCode;

    public static Intent getIntent(Context context, String boardCode) {
        Intent intent = new Intent(context, ThreadCatalogActivity.class);
        intent.putExtra(BOARD_EXTRA, boardCode);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_catalog);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final SwipeRefreshLayout refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);


        boardCode = getIntent().getStringExtra(BOARD_EXTRA);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://2ch.hk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DvachService service = retrofit.create(DvachService.class);
        final Call<BoardSimplified> call = service.getSimplifiedCatalog(boardCode);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                call.clone().enqueue(new Callback<BoardSimplified>() {
                    @Override
                    public void onResponse(Call<BoardSimplified> call, Response<BoardSimplified> response) {
                        if (response.isSuccessful()) {
                            recyclerView.setAdapter(new CatalogAdapter(response.body().getThreads()));
                        }
                        refresh.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<BoardSimplified> call, Throwable t) {
                        Toast.makeText(ThreadCatalogActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        refresh.setRefreshing(false);
                    }
                });
            }
        });
        call.enqueue(new Callback<BoardSimplified>() {
            @Override
            public void onResponse(Call<BoardSimplified> call, Response<BoardSimplified> response) {
                if (response.isSuccessful()) {
                    setTitle("/" + response.body().getBoard() + "/");
                    recyclerView.setAdapter(new CatalogAdapter(response.body().getThreads()));
                }
            }

            @Override
            public void onFailure(Call<BoardSimplified> call, Throwable t) {

            }
        });
    }

    private class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {

        private List<ThreadSimplified> threads;

        public CatalogAdapter(List<ThreadSimplified> threads) {
            this.threads = threads;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView timestamp;
            TextView comment;
            TextView subject;
            TextView score;
            TextView views;
            TextView posts;

            public ViewHolder(View itemView) {
                super(itemView);

                timestamp = (TextView) itemView.findViewById(R.id.timestamp);
                comment = (TextView) itemView.findViewById(R.id.comment);
                subject = (TextView) itemView.findViewById(R.id.subject);
                score = (TextView) itemView.findViewById(R.id.score);
                views = (TextView) itemView.findViewById(R.id.views);
                posts = (TextView) itemView.findViewById(R.id.posts);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thread_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final ThreadSimplified thread = threads.get(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(ThreadActivity.getIntent(ThreadCatalogActivity.this,
                            boardCode, thread.getNum()));
                }
            });
            holder.timestamp.setText(new SimpleDateFormat("HH:mm:ss dd.MM.yyyy", new Locale("ru"))
                    .format(new Date(thread.getTimestamp() * 1000)));
            holder.comment.setText(Html.fromHtml(thread.getComment()));
            holder.subject.setText(Html.fromHtml(thread.getSubject()));
            holder.views.setText(String.format(Locale.US, "%d", thread.getViews()));
            holder.score.setText(new DecimalFormat("#.##").format(thread.getScore()));
            holder.posts.setText(String.format(Locale.US, "%d", thread.getPostsCount()));
        }

        @Override
        public int getItemCount() {
            return threads.size();
        }
    }
}
