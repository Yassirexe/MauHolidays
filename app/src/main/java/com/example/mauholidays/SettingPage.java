package com.example.mauholidays;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;

public class SettingPage  extends AppCompatActivity {

    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingpage);

        DB = new DBHelper(this);

        String username = readUsername("username.txt");
        TextView UserTitle = (TextView) findViewById(R.id.settingUserName);
        UserTitle.setText(username);

        Button goToEdit = findViewById(R.id.buttonEdit);

        goToEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, EditProfile.class);
                startActivity(intent);
            }
        });

//        logout

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = getFilesDir();
                File file = new File(dir, "username.txt");
                boolean deleted = file.delete();
                if(deleted) {
                    Intent intent = new Intent(SettingPage.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

//        Button navbar

        findViewById(R.id.exploreScreen4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, videoMain.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.homescreen4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, Home.class);
                startActivity(intent);
            }
        });


        TextView favScreen = (TextView) findViewById(R.id.favscreen4);

        favScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, Favourite.class);
                startActivity(intent);
            }
        });




    }

    public String readUsername(String filePath) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, filePath);
        if(readFrom.exists()) {
            byte[] name = new byte[(int) readFrom.length()];
            try {
                FileInputStream stream = new FileInputStream(readFrom);
                stream.read(name);
                return new String(name);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new String("Guest");
    }

}

