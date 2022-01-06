package com.example.iqapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class BlogLoader extends AsyncTaskLoader<List<Blog>> {

    private final String mUrl;

    public BlogLoader(@NonNull Context context,String url) {
        super(context);
        mUrl = url;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    @Nullable
    @Override
    public List<Blog> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        return Utils.fetchBlogData(mUrl);
    }
}
