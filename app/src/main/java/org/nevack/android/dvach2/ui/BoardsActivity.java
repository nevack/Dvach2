package org.nevack.android.dvach2.ui;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.nevack.android.dvach2.DvachService;
import org.nevack.android.dvach2.R;
import org.nevack.android.dvach2.model.BoardConfig;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoardsActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private final int SUBHEADER = R.layout.board_list_subheader;
    private final int LIST_ITEM = R.layout.board_list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://2ch.hk/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        DvachService service = retrofit.create(DvachService.class);

        final List<Item> items = new LinkedList<>();

        Call<Map<String, List<BoardConfig>>> boardConfig = service.getBoardConfig();
        boardConfig.enqueue(new Callback<Map<String, List<BoardConfig>>>() {
            @Override
            public void onResponse(Call<Map<String, List<BoardConfig>>> call,
                                   Response<Map<String, List<BoardConfig>>> response) {
                if (response.isSuccessful()) {
                    for (Map.Entry<String, List<BoardConfig>> entry : response.body().entrySet()) {
                        items.add(new Item(SUBHEADER, entry.getValue().get(0)));
                        for (BoardConfig config : entry.getValue()) {
                            items.add(new Item(LIST_ITEM, config));
                        }
                    }
                    recyclerView.setAdapter(new BoardsConfigAdapter(items));
                }
            }

            @Override
            public void onFailure(Call<Map<String, List<BoardConfig>>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_boards, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                startActivity(ThreadCatalogActivity.getIntent(BoardsActivity.this, query));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    private class Item {
        private int type;
        private BoardConfig config;

        public Item(int type, BoardConfig config) {
            this.type = type;
            this.config = config;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return config.getName();
        }

        public BoardConfig getConfig() {
            return config;
        }
    }

    private class BoardsConfigAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Item> items;

        private int lastPosition = -1;

        BoardsConfigAdapter(List<Item> items) {
            this.items = items;
        }

        public class SubheaderViewHolder extends RecyclerView.ViewHolder{
            TextView mTextView;

            public SubheaderViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.subheader_title);
            }
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder{
            TextView mTextView;

            public ItemViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.board_title);
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(viewType, parent, false);
            switch (viewType) {
                case LIST_ITEM:
                    return new ItemViewHolder(view);
                case SUBHEADER:
                    return new SubheaderViewHolder(view);
            }

            throw new RuntimeException();
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            if (holder instanceof ItemViewHolder) {
                ((ItemViewHolder) holder).mTextView
                        .setText(items.get(position).getName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(ThreadCatalogActivity.getIntent(BoardsActivity.this,
                                items.get(position).getConfig().getId()));
                    }
                });
            } else if (holder instanceof SubheaderViewHolder) {
                ((SubheaderViewHolder) holder).mTextView
                        .setText(items.get(position).getName());
            }

            setAnimation(holder.itemView, position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).getType();
        }

        @Override
        public void onViewDetachedFromWindow(final RecyclerView.ViewHolder holder)
        {
            super.onViewDetachedFromWindow(holder);
            holder.itemView.clearAnimation();
        }

        private void setAnimation(View viewToAnimate, int position)
        {
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition)
            {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_up);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }
    }
}
