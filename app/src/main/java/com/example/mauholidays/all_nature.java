package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class all_nature extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_nature);

        ImageButton back = findViewById(R.id.back);
        RelativeLayout ssr = findViewById(R.id.ssrg);
        RelativeLayout pieterBoth = findViewById(R.id.pieterBoth);
        RelativeLayout lemorne = findViewById(R.id.lemorne);
        RelativeLayout casela = findViewById(R.id.caselaSafari);
        RelativeLayout naturepark = findViewById(R.id.naturepark);
        RelativeLayout blackriver = findViewById(R.id.blackriver);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, Home.class);
                startActivity(intent);
            }
        });
        ssr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, ssrBotanicalGarden.class);
                startActivity(intent);
            }
        });

        pieterBoth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, pieterBoth.class);
                startActivity(intent);
            }
        });

        lemorne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, leMorne.class);
                startActivity(intent);
            }
        });

        casela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, safari.class);
                startActivity(intent);
            }
        });

        naturepark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, nature_park.class);
                startActivity(intent);
            }
        });

        blackriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, black_river.class);
                startActivity(intent);
            }
        });

//        navbar

        findViewById(R.id.homescreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, Home.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exploreScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.favscreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, Favourite.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profileScreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_nature.this, SettingPage.class);
                startActivity(intent);
            }
        });

//        code end
    }
}