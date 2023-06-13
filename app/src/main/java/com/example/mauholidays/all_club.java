package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class all_club extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_club);

        ImageButton back = findViewById(R.id.back);
        RelativeLayout inso= findViewById(R.id.inso);
        RelativeLayout omgc = findViewById(R.id.omgc);
        RelativeLayout lkz = findViewById(R.id.lkz);
        RelativeLayout banana = findViewById(R.id.banana);
        RelativeLayout kenzi = findViewById(R.id.kenzi);
        RelativeLayout shotz = findViewById(R.id.shotz);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, Home.class);
                startActivity(intent);
            }
        });
        inso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, club_insomnia.class);
                startActivity(intent);
            }
        });

        omgc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, club_omg.class);
                startActivity(intent);
            }
        });

        lkz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, club_lakaz.class);
                startActivity(intent);
            }
        });

        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, club_banana.class);
                startActivity(intent);
            }
        });

        kenzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, club_kenzi.class);
                startActivity(intent);
            }
        });

        shotz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, club_shot.class);
                startActivity(intent);
            }
        });

//        navbar

        findViewById(R.id.homescreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, Home.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exploreScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.favscreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, Favourite.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profileScreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_club.this, SettingPage.class);
                startActivity(intent);
            }
        });
//        code end
    }
}