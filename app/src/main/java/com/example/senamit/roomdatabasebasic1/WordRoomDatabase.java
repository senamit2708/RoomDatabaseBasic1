package com.example.senamit.roomdatabasebasic1;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by senamit on 20/3/18.
 */
//here in the entities we will enter all the class that are entity
    //and version no will increase if database will be updated , i dont know clearly about version now
    //abstract classs and also extends the RoomDatabase
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {
    //here we r creating the abstract method for all the @Dao class,
    //currently we have only one, so only one is created
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;

    //here we r making the class as singletone, it means only one object of class will be created
    //to prevent multiple instance of database opened at the same time.
    static WordRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if (INSTANCE ==null){
                    //database is created here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback = new WordRoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDBAsync(INSTANCE).execute();
        }
    };

}
