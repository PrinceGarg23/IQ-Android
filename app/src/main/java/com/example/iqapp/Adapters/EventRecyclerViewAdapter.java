package com.example.iqapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.iqapp.Event;
import com.example.iqapp.R;

import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventViewHolder> {
    Context mContext;
    List<Event> mEvents;

    public EventRecyclerViewAdapter(Context context,List<Event> events){
        mContext=context;
        mEvents=events;
    }

    @NonNull
    @Override
    public EventRecyclerViewAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.event_view,parent,false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventRecyclerViewAdapter.EventViewHolder holder, int position) {
        position = getItemCount()-position-1;
        Event currentEvent = mEvents.get(position);
        String name = currentEvent.getName();
        String date = currentEvent.getDate();
        String poster = currentEvent.getPoster();
        String url = currentEvent.getUrl();
        holder.eventName.setText(name);
        holder.eventDate.setText(date);
        Glide.with(mContext).load(poster).into(holder.posterView);
        holder.posterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{
        ImageView posterView;
        TextView eventName;
        TextView eventDate;
        public EventViewHolder(@NonNull View itemView){
            super(itemView);
            posterView = itemView.findViewById(R.id.event_poster);
            eventDate = itemView.findViewById(R.id.event_date);
            eventName = itemView.findViewById(R.id.event_name);
        }
    }
}
