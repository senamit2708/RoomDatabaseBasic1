package com.example.senamit.roomdatabasebasic1;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by senamit on 20/3/18.
 */

public class WordViewModel extends AndroidViewModel {

    //for holding the reference of repository
    private WordRepository mRepository;
    //adding a private live data for catching the list of words
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return  mAllWords;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }
}
