package com.example.iqapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.iqapp.Adapters.BlogRecyclerViewAdapter;
import com.example.iqapp.Adapters.EventRecyclerViewAdapter;
import com.example.iqapp.Event;
import com.example.iqapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity{
    List<Event> events;
    FirebaseDatabase firebaseDatabase;

    private  static  final int LOADER_ID = 1;
    RecyclerView eventRecyclerView;
    EventRecyclerViewAdapter adapter;
    View load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        load = findViewById(R.id.loading_indicator);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            eventRecyclerView = findViewById(R.id.event_re_view);

            events = new ArrayList<>();
            firebaseDatabase = FirebaseDatabase.getInstance("https://iq-app-b78ad-default-rtdb.firebaseio.com/");
            DatabaseReference eventReference = firebaseDatabase.getReference("Events");
            eventReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    events.clear();
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        Event currentEvent = dataSnapshot.getValue(Event.class);
                        events.add(currentEvent);
                    }
                    load.setVisibility(View.GONE);
                    eventRecyclerView.setLayoutManager(new GridLayoutManager(EventActivity.this,2));
                    adapter = new EventRecyclerViewAdapter(EventActivity.this,events);
                    eventRecyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });




        }else{
            Toast.makeText(getApplicationContext(),"No internet Connection",Toast.LENGTH_LONG).show();
            load.setVisibility(View.GONE);
            finish();
            return;
        }

    }

}