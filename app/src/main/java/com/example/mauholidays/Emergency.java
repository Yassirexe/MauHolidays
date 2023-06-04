package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Emergency extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        LinearLayout accident = (LinearLayout) findViewById(R.id.accidentFrame);
        LinearLayout fire = (LinearLayout) findViewById(R.id.fireFrame);
        LinearLayout drown = (LinearLayout) findViewById(R.id.drowningFrame);
        LinearLayout health = (LinearLayout) findViewById(R.id.healthFrame);
        LinearLayout thief = (LinearLayout) findViewById(R.id.thiefFrame);

        accident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "114"));// Initiates the Intent
                startActivity(intent);
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "115"));// Initiates the Intent
                startActivity(intent);
            }
        });

        drown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "112"));// Initiates the Intent
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "114"));// Initiates the Intent
                startActivity(intent);
            }
        });

        thief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "112"));// Initiates the Intent
                startActivity(intent);
            }
        });

        ImageView backToHome = (ImageView) findViewById(R.id.backToHomeFromEmergency);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emergency.this, Home.class);
                startActivity(intent);
            }
        });

    }
}