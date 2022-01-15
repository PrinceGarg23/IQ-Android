package com.example.iqapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iqapp.Adapters.BoardRecyclerViewAdapter;
import com.example.iqapp.R;

public class BoardActivity extends AppCompatActivity {

    RecyclerView r;

    String[] names = {"a","b","c","d"};
    String[] position = {"e","f","g","h"};
    String[] photo = {"https://res.cloudinary.com/iquest2308/image/upload/v1640893945/samples/people/kitchen-bar.jpg","https://res.cloudinary.com/iquest2308/image/upload/v1640893941/sample.jpg","https://res.cloudinary.com/iquest2308/image/upload/v1640893941/sample.jpg","https://res.cloudinary.com/iquest2308/image/upload/v1640893941/sample.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        r = findViewById(R.id.boardMembers);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.setAdapter(new BoardRecyclerViewAdapter(BoardActivity.this,names,position,photo));
    }
}