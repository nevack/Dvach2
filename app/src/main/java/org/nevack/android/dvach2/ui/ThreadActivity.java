package org.nevack.android.dvach2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.nevack.android.dvach2.DvachService;
import org.nevack.android.dvach2.R;
import org.nevack.android.dvach2.Utils;
import org.nevack.android.dvach2.model.Board;
import org.nevack.android.dvach2.model.File;
import org.nevack.android.dvach2.model.Post;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.nevack.android.dvach2.model.File.TYPE_GIF;
import static org.nevack.android.dvach2.model.File.TYPE_PIC;
import static org.nevack.android.dvach2.model.File.TYPE_STICKER;
import static org.nevack.android.dvach2.model.File.TYPE_WEBM;

public class ThreadActivity extends AppCompatActivity {

    private static final String BOARD_EXTRA = "boardcode";
    private static final String THREAD_EXTRA = "threadnum";

    public static Intent getIntent(Context context, String boardCode, Integer threadNum) {
        Intent intent = new Intent(context, ThreadActivity.class);
        intent.putExtra(BOARD_EXTRA, boardCode);
        intent.putExtra(THREAD_EXTRA, threadNum);
        return intent;
    }

    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_post);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final String boardCode = getIntent().getStringExtra(BOARD_EXTRA);
        final int threadNum = getIntent().getIntExtra(THREAD_EXTRA, 0);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PostActivity.getIntent(
                        ThreadActivity.this,
                        boardCode,
                        threadNum
                ));
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://2ch.hk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DvachService service = retrofit.create(DvachService.class);
        Call<Board> call = service.getThread(boardCode, threadNum);
        call.enqueue(new Callback<Board>() {
            @Override
            public void onResponse(Call<Board> call, Response<Board> response) {
                if (response.isSuccessful()) {
                    recyclerView.setAdapter(new ThreadAdapter(response.body()
                            .getThreads().get(0).getPosts()));
                    setTitle(Html.fromHtml(response.body().getThreads().get(0).getPosts().get(0).getComment()));
                    getSupportActionBar().setSubtitle(
                            "#" + response.body().getThreads().get(0).getPosts().get(0).getNum() +
                                    " on /" + response.body().getBoard() + "/"
                    );
                }
            }

            @Override
            public void onFailure(Call<Board> call, Throwable t) {}
        });

    }

    private class ThreadAdapter extends RecyclerView.Adapter<ThreadAdapter.ViewHolder> {

        private List<Post> threads;

        ThreadAdapter(List<Post> threads) {
            this.threads = threads;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView timestamp;
            TextView comment;
            TextView name;
            TextView filescount;
            ImageView thumbimage;
            TextView thumbinfo;
            LinearLayout thumbnails;

            ViewHolder(View itemView) {
                super(itemView);
                timestamp = (TextView) itemView.findViewById(R.id.timestamp);
                comment = (TextView) itemView.findViewById(R.id.comment);
                name = (TextView) itemView.findViewById(R.id.name);
                filescount = (TextView) itemView.findViewById(R.id.filescount);
                thumbimage = (ImageView) itemView.findViewById(R.id.thumbnail_image);
                thumbinfo = (TextView) itemView.findViewById(R.id.thumbnail_info);
                thumbnails = (LinearLayout) itemView.findViewById(R.id.thumbnails_container);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Post post = threads.get(position);
            holder.timestamp.setText(new SimpleDateFormat("HH:mm:ss dd.MM.yyyy", new Locale("ru"))
                    .format(new Date(post.getTimestamp() * 1000)));
            holder.comment.setText(Html.fromHtml(post.getComment()));
            holder.name.setText(post.getName());
            if (holder.thumbnails.getChildCount() > 0) holder.thumbnails.removeAllViews();

            int files = post.getFiles().size();
            if (files > 0) {
                holder.thumbnails.setVisibility(View.VISIBLE);
                holder.filescount.setVisibility(View.VISIBLE);
                holder.filescount.setText(String.valueOf(files));
                for (final File file : post.getFiles()) {
                    View view = LayoutInflater.from(holder.thumbnails.getContext())
                            .inflate(R.layout.thumbnail, holder.thumbnails, false);
                    ImageView image = (ImageView) view.findViewById(R.id.thumbnail_image);
                    final TextView info = (TextView) view.findViewById(R.id.thumbnail_info);
                    info.setText(Utils.formatSize(file.getSize()));
                    holder.thumbnails.addView(view);
                    Utils.getPicasso(ThreadActivity.this)
                            .load("https://2ch.hk" + file.getThumbnail())
                            .into(image);
                    int drawable;
                    switch (file.getType()) {
                        case TYPE_GIF:
                            drawable = R.drawable.ic_gif_white_18dp;
                            break;
                        case TYPE_WEBM:
                            drawable = R.drawable.ic_movie_white_18dp;
                            break;
                        case TYPE_STICKER:
                            drawable = R.drawable.ic_smile_white_18dp;
                            break;
                        case TYPE_PIC:
                        default:
                            drawable = R.drawable.ic_image_white_18dp;
                    }
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = ContentActivity
                                    .newInstance(ThreadActivity.this,
                                            "https://2ch.hk" + file.getPath(),
                                            file.getType());
                            startActivity(intent);
                        }
                    });
                    info.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
                }
            } else {
                holder.thumbnails.setVisibility(View.GONE);
                holder.filescount.setVisibility(View.GONE);
            }

            holder.itemView.setTag(post.getNum());
        }

        @Override
        public int getItemCount() {
            return threads.size();
        }
    }
}
