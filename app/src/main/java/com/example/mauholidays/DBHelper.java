package com.example.mauholidays;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //name of database that will be created on device itself
    public static final String DBNAME = "Login.db";
    public String username1 = "";

    public DBHelper(Context context) {
        super(context, "Login.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //create tables users wth 2 columns username and password
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

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
        username1 = username;

        // if statement to check if insertion is successful or not

        if (result == -1)
            return false;
            else
                return true;

    }


    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public boolean checkuserpassword(String username , String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        if (cursor.getCount() > 0)
        {
            username1 = username;
            return true;
        }
        else
            return false;

    }

    public void getAllUsers() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users", new String[] {});
        System.out.println(cursor);
    }

}
























