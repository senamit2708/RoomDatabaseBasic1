package com.example.senamit.roomdatabasebasic1;

import android.os.AsyncTask;

/**
 * Created by senamit on 25/3/18.
 */

public class PopulateDBAsync extends AsyncTask<Void, Void, Void> {

    private WordDao mDao;

    PopulateDBAsync(WordRoomDatabase db){
        mDao = db.wordDao();
    }


    @Override
    protected Void doInBackground(Void... params) {
        mDao.deleteAll();
//        Word word = new Word("hello");
//        mDao.insert(word);
        Word word1 = new Word("Room");
        mDao.insert(word1);
        return  null;
    }
}
