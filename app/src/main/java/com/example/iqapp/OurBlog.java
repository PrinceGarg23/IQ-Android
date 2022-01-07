package com.example.iqapp;

import static com.example.iqapp.Utils.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.app.LoaderManager.LoaderCallbacks;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public  class OurBlog extends AppCompatActivity implements LoaderCallbacks<List<Blog>>{
    private  static  final int LOADER_ID = 1;
    RecyclerView blogRecyclerView;
    BlogRecyclerViewAdapter adapter;
    View load;
    private static final String MediumApi = "https://api.rss2json.com/v1/api.json?rss_url=https://medium.com/feed/@documentation.iquestvit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_blog);
         load = findViewById(R.id.loading_indicator);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(LOADER_ID, null, this).forceLoad();
            blogRecyclerView = findViewById(R.id.blog_re_view);
        }else{
            Toast.makeText(getApplicationContext(),"No internet Connection",Toast.LENGTH_LONG).show();
            load.setVisibility(View.GONE);
            return;
        }
        blogRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BlogRecyclerViewAdapter(OurBlog.this,new ArrayList<>());
        blogRecyclerView.setAdapter(adapter);

    }

    @Override
    public Loader<List<Blog>> onCreateLoader(int id, Bundle args) {
        return  new BlogLoader(this,MediumApi);
    }

    @Override
    public void onLoadFinished(Loader<List<Blog>> loader, List<Blog> data) {
        load.setVisibility(View.GONE);
            adapter.swapDataSet(data);

    }

    @Override
    public void onLoaderReset(Loader<List<Blog>> loader) {

    }

}