package com.example.senamit.roomdatabasebasic1;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by senamit on 20/3/18.
 */
@Dao
public interface wordDao {

    @Insert
     void insert(Word word);

    @Query("DELETE FROM word_table")
     void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();


}
