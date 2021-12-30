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

public class BoardRecyclerViewAdapter extends RecyclerView.Adapter<BoardRecyclerViewAdapter.BoardViewHolder>{
    private String[] name;
    private String[] position;
    private String[] image;

    Context context;

    public BoardRecyclerViewAdapter(Context context,String[] name, String[] position, String[] image) {
        this.context = context;
        this.name = name;
        this.position = position;
        this.image = image;
    }

    @NonNull
    @Override
    public  BoardRecyclerViewAdapter.BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.board_view,parent,false);
        return new BoardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardRecyclerViewAdapter.BoardViewHolder holder, int p) {
        Glide.with(context).load(image[p]).placeholder(R.drawable.ic_board).dontAnimate().into(holder.photo);
        holder.name.setText(name[p]);
        holder.position.setText(position[p]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView name;
        TextView position;
        public BoardViewHolder(@NonNull View itemView){
            super(itemView);
            photo = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            position = itemView.findViewById(R.id.position);
        }
    }


}
