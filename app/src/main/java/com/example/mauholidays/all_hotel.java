package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class all_hotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_hotel);


        ImageButton back = findViewById(R.id.back);
        RelativeLayout preskillHotel = findViewById(R.id.preskil);
        RelativeLayout mariott = findViewById(R.id.mariott);
        RelativeLayout amber = findViewById(R.id.amber);
        RelativeLayout maritim = findViewById(R.id.maritim);
        RelativeLayout sofitel = findViewById(R.id.sofitel);
        RelativeLayout outrigger = findViewById(R.id.outrigger);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, Home.class);
                startActivity(intent);
            }
        });
        preskillHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, hotel_preski.class);
                startActivity(intent);
            }
        });

        mariott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, hotel_mariotte.class);
                startActivity(intent);
            }
        });

        amber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, hotel_amber.class);
                startActivity(intent);
            }
        });

        maritim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, hotel_maritim.class);
                startActivity(intent);
            }
        });

        sofitel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, hotel_sofitel.class);
                startActivity(intent);
            }
        });

        outrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, hotel_outrigger.class);
                startActivity(intent);
            }
        });

//        navbar

        findViewById(R.id.homescreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, Home.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exploreScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.favscreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, Favourite.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profileScreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_hotel.this, SettingPage.class);
                startActivity(intent);
            }
        });


    }
}