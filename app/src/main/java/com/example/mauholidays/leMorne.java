package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileInputStream;

public class leMorne extends AppCompatActivity {

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_morne);

        DB = new DBHelper(this);
        ImageButton back = (ImageButton) findViewById(R.id.back);


        CheckBox fav5 = (CheckBox) findViewById(R.id.favourite5);
        fav5.setChecked(false);
        fav5.setButtonDrawable(R.drawable.baseline_favorite_border_24);

        fav5.setOnClickListener(new View.OnClickListener() {
            String username = readUsername("username.txt");
            @Override
            public void onClick(View v) {
                if(!fav5.isChecked()) {
                    DB.removeFromFav(username,"le_morne-3");
                    fav5.setButtonDrawable(R.drawable.baseline_favorite_border_24);
                }else {
                    DB.addToFavourite(username,"le_morne-3");
                    fav5.setButtonDrawable(R.drawable.heart_red);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(leMorne.this, all_nature.class);
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