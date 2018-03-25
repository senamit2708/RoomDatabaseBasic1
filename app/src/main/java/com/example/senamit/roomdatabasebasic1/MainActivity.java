package com.example.senamit.roomdatabasebasic1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

        fab = findViewById(R.id.floatingActionButton);
        recyclerViewWords = findViewById(R.id.recyclerView);
        layoutManager =  new LinearLayoutManager(this);
        wordListAdapter = new WordListAdapter(this);
        recyclerViewWords.setLayoutManager(layoutManager);
        recyclerViewWords.setAdapter(wordListAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContentMain.class);
                startActivity(intent);

            }
        });

    }
}
