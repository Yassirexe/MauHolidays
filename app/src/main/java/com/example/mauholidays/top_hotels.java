package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class top_hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_hotels);

        ImageButton back = findViewById(R.id.back);
        ImageView preskillHotel = findViewById(R.id.preskil);
        ImageView mariott = findViewById(R.id.mariott);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(top_hotels.this, Home.class);
                startActivity(intent);
            }
        });
        preskillHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(top_hotels.this, hotel_preski.class);
                startActivity(intent);
            }
        });

        mariott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(top_hotels.this, hotel_mariotte.class);
                startActivity(intent);
            }
        });

    }
}