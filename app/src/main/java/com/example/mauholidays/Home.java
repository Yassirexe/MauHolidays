package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Home extends AppCompatActivity {

    TextView usernamehome;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernamehome = findViewById(R.id.homeusername);
        String username = readUsername("username.txt");
        usernamehome.setText(username);

        TextView favScreen = (TextView) findViewById(R.id.favscreen1);

        favScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Favourite.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.jumptoquiz).setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                Intent intent = new Intent(Home.this, Menu.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.goToMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, map.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.toHotel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, all_hotel.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.toNature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, all_nature.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.toClub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, all_club.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.goToEmergency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Emergency.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.goToExchangeRate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, currency.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exploreScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profileScreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SettingPage.class);
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