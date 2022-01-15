package com.example.iqapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.iqapp.Blog;
import com.example.iqapp.R;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        Blog currentBlog = mBlogs.get(position);
        String title = currentBlog.getTitle();
        String thumbnail = currentBlog.getThumbnail();
        String desc = currentBlog.getDescription();
        String link = currentBlog.getLink();
        Document document = Jsoup.parse(desc);
        Elements elements = document.select("p");
        List<String> a = new ArrayList<>();
        for(Element element : elements){
            String tagName = element.tagName();
            a.add(element.text());
        }
        Glide.with(mContext).load(thumbnail).placeholder(R.drawable.ic_medium1).dontAnimate().into(holder.photo);
        holder.title.setText(Html.fromHtml(title,Html.FROM_HTML_MODE_LEGACY));
        holder.desc.setText(a.get(1));
        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBlogs.size();
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView title;
        TextView desc;
        View visit;
        public BlogViewHolder(@NonNull View itemView){
            super(itemView);
            photo = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.writer);
            visit = itemView.findViewById(R.id.link);
        }
    }
    public void swapDataSet(List<Blog> newData){

        mBlogs = newData;

        //now, tell the adapter about the update
        notifyDataSetChanged();

    }

}
