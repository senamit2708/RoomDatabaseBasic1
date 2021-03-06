package com.example.senamit.roomdatabasebasic1;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by senamit on 20/3/18.
 */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @ColumnInfo(name="testpart")
    private String testCol;



    public Word(@NonNull String word) {
        this.mWord = word;
    }

    @NonNull
    public String getWord() {
        return mWord;
    }

    public String getTestCol() {
        return testCol;
    }

    public void setTestCol(String testCol) {
        this.testCol = testCol;
    }
}
