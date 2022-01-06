package com.example.iqapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BlogRecyclerViewAdapter extends RecyclerView.Adapter<BlogRecyclerViewAdapter.BlogViewHolder> {
    Context mContext;
    List<Blog> mBlogs;

    public BlogRecyclerViewAdapter(Context context, List<Blog> blogs){
        mBlogs = blogs;
        mContext = context;
    }

    @NonNull
    @Override
    public BlogRecyclerViewAdapter.BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.blog_view,parent,false);
        return new BlogViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogRecyclerViewAdapter.BlogViewHolder holder, int position) {
        Blog currentBlog = mBlogs.get(position);
        String title = currentBlog.getTitle();
        String thumbnail = currentBlog.getThumbnail();
        String desc = currentBlog.getDescription();
        Glide.with(mContext).load(thumbnail).placeholder(R.drawable.ic_board).dontAnimate().into(holder.photo);
        holder.title.setText(title);
        holder.desc.setText(desc);
    }

    @Override
    public int getItemCount() {
        return mBlogs.size();
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView title;
        TextView desc;
        public BlogViewHolder(@NonNull View itemView){
            super(itemView);
            photo = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.writer);
        }
    }
    public void swapDataSet(List<Blog> newData){

        mBlogs = newData;

        //now, tell the adapter about the update
        notifyDataSetChanged();

    }

}
