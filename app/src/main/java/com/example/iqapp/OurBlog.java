package com.example.iqapp;

import static com.example.iqapp.Utils.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Loader;
import android.app.LoaderManager.LoaderCallbacks;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public  class OurBlog extends AppCompatActivity implements LoaderCallbacks<List<Blog>>{
    private  static  final int LOADER_ID = 1;
    RecyclerView blogRecyclerView;
    BlogRecyclerViewAdapter adapter;
    private static final String MediumApi = "https://api.rss2json.com/v1/api.json?rss_url=https://medium.com/feed/@documentation.iquestvit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_blog);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this).forceLoad();
        blogRecyclerView = findViewById(R.id.blog_re_view);
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
            adapter.swapDataSet(data);

    }

    @Override
    public void onLoaderReset(Loader<List<Blog>> loader) {

    }
}