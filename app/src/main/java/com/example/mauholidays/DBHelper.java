package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

public class DBHelper extends SQLiteOpenHelper {

    //name of database that will be created on device itself
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //create tables users wth 2 columns username and password
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table favourites(username TEXT, favouritePlace TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists favourites");
    }

    //method to inset data i.e. username and password

    public boolean insertdata (String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // "colummn name" , variables
        contentValues.put("Username", username);
        contentValues.put("password", password);
        //insert values in table
        long result = MyDB.insert("users", null, contentValues);

        // if statement to check if insertion is successful or not

        if (result == -1)
            return false;
            else
                return true;
    }

    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});

        if (cursor.getCount() > 0) {
            return true;
        }

        else
            return false;

    }

    public boolean checkuserpassword(String username , String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public void addToFavourite(String username,String place) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("INSERT INTO favourites VALUES (username,place)", new String[] {username, place});
    }

    public ArrayList<String> getFavourite(String username) {
        ArrayList<String> favItem = new ArrayList<>();
        favItem.add(" ");
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT favouritePlace FROM favourites where username = ?", new String[] {username});
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false)
        {
           favItem.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return favItem;
    }


}
























