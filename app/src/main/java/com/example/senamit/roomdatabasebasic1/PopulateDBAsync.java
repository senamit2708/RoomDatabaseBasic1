package com.example.senamit.roomdatabasebasic1;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by senamit on 25/3/18.
 */

public class PopulateDBAsync extends AsyncTask<Void, Void, Void> {

    private static final String LOG_TAG= PopulateDBAsync.class.getSimpleName();

    private WordDao mDao;

    PopulateDBAsync(WordRoomDatabase db){
        mDao = db.wordDao();
    }



    @Override
    protected Void doInBackground(Void... params) {
        Log.i(LOG_TAG, "inside populate database");
        mDao.deleteAll();
//        Word word = new Word("hello");
//        mDao.insert(word);
        Word word1 = new Word("Room");
        mDao.insert(word1);
        return  null;
    }
}
