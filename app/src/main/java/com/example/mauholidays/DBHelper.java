package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //create tables users wth 2 columns username and password
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table favourites(username TEXT, place TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists favourites");
    }

    //method to inset data i.e. username and password

    public boolean insertdata(String username, String password) {
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

    public boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});

        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;

    }

    public boolean checkuserpassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public boolean updateProfile(String oldUsername, String password, String newUsername) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", newUsername);
        values.put("password", password);

        String table = "users"; // Replace "table_name" with the actual table name
        String whereClause = "username = ?"; // Replace "column_name" with the actual column name used in the WHERE clause
        String[] whereArgs = {oldUsername}; // Replace "valueToMatch" with the specific value that identifies the row(s) you want to update

        int rowsAffected = MyDB.update(table, values, whereClause, whereArgs);
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }


    }

    public void addToFavourite(String username, String place) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // "colummn name" , variables
        contentValues.put("username", username);
        contentValues.put("place", place);
        //insert values in table
        long result = MyDB.insert("favourites", null, contentValues);
    }

    public void removeFromFav(String username, String place) {
        SQLiteDatabase MyDB = this.getWritableDatabase();

        // Define the WHERE clause and its arguments
        String whereClause = "username = ? AND place = ?";
        String[] whereArgs = {username, place};

        // Perform the deletion
        MyDB.delete("favourites", whereClause, whereArgs);

        // Close the database
        MyDB.close();

    }

    public ArrayList<String> getFavourite(String usernames) {
        ArrayList<String> favItem = new ArrayList<>();
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        String[] columns = {"place"};
//
//        String selection = "username = ?";
//        String[] selectionArgs = {usernames};
//
//        Cursor cursor = MyDB.query("favourites", columns, selection, selectionArgs, null, null, null);
//
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                do {
//                    String selectedValue = cursor.getString(cursor.getColumnIndex("place"));
//                    favItem.add(selectedValue);
//                } while (cursor.moveToNext());
//            }
//            cursor.close();
//        }
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select place from favourites where username = ?", new String[]{usernames});

        favItem.add(" ");
        if (cursor.moveToFirst()){
            do {
                // Passing values
                String column1 = cursor.getString(0);
                favItem.add(column1);

            } while(cursor.moveToNext());
        }
        cursor.close();
        MyDB.close();

        return favItem;
    }

    public boolean getInfo(String usernames, String place) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select place from favourites where username = ? and place = ?", new String[]{usernames, place});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;


    }

}
























