package com.example.senamit.roomdatabasebasic1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    FloatingActionButton fab;
    RecyclerView recyclerViewWords;
    WordListAdapter wordListAdapter;
    RecyclerView.LayoutManager layoutManager;
    private WordViewModel mWordViewModel;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode==RESULT_OK){
            Word word = new Word(data.getStringExtra(ContentMain.RESULT_EXTRA));
            mWordViewModel.insert(word);
        }else {
            Toast.makeText(getApplicationContext(), R.string.word_not_Saved, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG,"inside the main activity on create method");

        //associating view model with the UI
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        List<Word> words = new ArrayList<Word>();
//        words.add(new Word("Hello"));
//        words.add(new Word("Room"));


        fab = findViewById(R.id.floatingActionButton);
        recyclerViewWords = findViewById(R.id.recyclerView);
        layoutManager =  new LinearLayoutManager(this);
        wordListAdapter = new WordListAdapter(this);
//       wordListAdapter.setWord(words);
        recyclerViewWords.setLayoutManager(layoutManager);
        recyclerViewWords.setAdapter(wordListAdapter);
        Log.i(LOG_TAG,"inside the main activity on create method----2");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContentMain.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);

            }
        });

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                wordListAdapter.setWord(words);
            }
        });


    }


}
