package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class all_top extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_top);

        ImageButton back = findViewById(R.id.back);
        RelativeLayout red= findViewById(R.id.red);
        RelativeLayout croisette = findViewById(R.id.croissette);
        RelativeLayout caudan = findViewById(R.id.caudan);
        RelativeLayout sitar = findViewById(R.id.sitar);
        RelativeLayout baga = findViewById(R.id.baga);
        RelativeLayout choisy = findViewById(R.id.choisy);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, Home.class);
                startActivity(intent);
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, theRedChurch.class);
                startActivity(intent);
            }
        });

        croisette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, laCroisette.class);
                startActivity(intent);
            }
        });

        caudan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, caudanwaterfront.class);
                startActivity(intent);
            }
        });

        sitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, sitarIndianFood.class);
                startActivity(intent);
            }
        });

        baga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, bagatelle.class);
                startActivity(intent);
            }
        });

        choisy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, mont_choisy.class);
                startActivity(intent);
            }
        });

//        navbar

        findViewById(R.id.homescreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, Home.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exploreScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.favscreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, Favourite.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profileScreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_top.this, SettingPage.class);
                startActivity(intent);
            }
        });
//        code end

    }
}