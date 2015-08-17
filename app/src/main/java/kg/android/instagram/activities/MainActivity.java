package kg.android.instagram.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import kg.android.instagram.EndlessRecyclerOnScrollListener;
import kg.android.instagram.R;
import kg.android.instagram.adapters.MediaAdapter;
import kg.android.instagram.model.Feed;
import kg.android.instagram.model.Media;
import kg.android.instagram.network.RestClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;
    private String maxId;
    private List<Media> resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Timber.tag("MainActivity");
        mRecyclerView = (RecyclerView) findViewById(R.id.media_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        resources = new ArrayList<>();
        mAdapter = new MediaAdapter(resources);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                getFeed(maxId);
            }
        });
        getFeed(null);
    }

    private void getFeed(String maxId) {
        RestClient.get().getFeed(maxId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Feed>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e.getMessage());
                    }

                    @Override
                    public void onNext(Feed feed) {
                        MainActivity.this.maxId = feed.getPagination().getNextMaxId();
                        resources.addAll(feed.getData());
                        mAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
