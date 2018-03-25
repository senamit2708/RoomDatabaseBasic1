package com.example.senamit.roomdatabasebasic1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    FloatingActionButton fab;
    RecyclerView recyclerViewWords;
    WordListAdapter wordListAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG,"inside the main activity on create method");

        List<Word> words = new ArrayList<Word>();
        words.add(new Word("Hello"));
        words.add(new Word("Room"));


        fab = findViewById(R.id.floatingActionButton);
        recyclerViewWords = findViewById(R.id.recyclerView);
        layoutManager =  new LinearLayoutManager(this);
        wordListAdapter = new WordListAdapter(this);
       wordListAdapter.setWord(words);
        recyclerViewWords.setLayoutManager(layoutManager);
        recyclerViewWords.setAdapter(wordListAdapter);
        Log.i(LOG_TAG,"inside the main activity on create method----2");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContentMain.class);
                startActivity(intent);

            }
        });

    }


}
