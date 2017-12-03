package com.example.radustefan.firstapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Paul on 11/30/2017.
 */

@Dao
public interface UserDao {

    @Query("select * from users where username = :user and password = :pass")
    public User getUser(String user, String pass);

    @Query("select * from users where username = :user and password = :pass")
    public int verifyUser(String user, String pass);

    @Insert
    public void addUser(User user);

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);

    @Query("select * from users")
    public List<User> getAllUsers();
}
