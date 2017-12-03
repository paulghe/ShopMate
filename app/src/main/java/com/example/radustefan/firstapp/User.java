package com.example.radustefan.firstapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.ColorLong;
import android.support.annotation.NonNull;

/**
 * Created by Paul on 11/30/2017.
 */

@Entity(tableName = "users", indices = {@Index(value = {"username"},unique = true),
        @Index(value = {"email"},unique = true)})
public class User  {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userid")
    public int uid;

    @ColumnInfo(name = "username")
    public String username;

    public String password;
    public String email;


    public User()   { uid = 1;}


    public User(String username, String pass, String email) {
   //     this.uid = id;
        this.username = username;
        this.password = pass;
        this.email = email;
    }

    public User(int id) {
   //     this.uid = id;
 //       uid = 1;
    }
}
