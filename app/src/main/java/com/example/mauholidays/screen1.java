package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class screen1 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        findViewById(R.id.Monuments).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen1.this,screen18.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.publicHolidays).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen1.this,screen23.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.riddles).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen1.this,screen24.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.slogans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen1.this,screen25.class);
                startActivity(intent);
            }
        });



    }
}