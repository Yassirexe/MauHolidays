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

        findViewById(R.id.jumptoquiz).setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                Intent intent = new Intent(Home.this, screen345.class);
                startActivity(intent);
            }
        });
    }

    public String readUsername(String filePath) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, filePath);
        byte[] name = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(name);
            return new String(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}