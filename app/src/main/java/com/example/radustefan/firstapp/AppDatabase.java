package com.example.radustefan.firstapp;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Paul on 11/30/2017.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Users-database").build();
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();


}