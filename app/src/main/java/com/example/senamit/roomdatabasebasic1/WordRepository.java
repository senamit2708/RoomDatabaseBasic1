package com.example.senamit.roomdatabasebasic1;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by senamit on 20/3/18.
 */
//we r creating a repository class here , so that we can keep the database and UI layer
public class WordRepository {

    //lets create the variables as required
    //create the instance of @Dao class, so that we can access its function
    //here we created mAllWords as variable, so that we can save the database result and send it to
    // the UI for display
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        //creating the database instance
        //initializing the @Dao class instance
        //getting the result of the query of list of all the words.
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    // i think observed live data will notify the observer when the data has changed
    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }
    //we cant run room query on main thread, so async should be used else it will give compile time error
    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... param) {
            mAsyncTaskDao.insert(param[0]);
            return null;
        }
    }


}
