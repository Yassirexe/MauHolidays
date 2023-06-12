package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileInputStream;

public class caudanwaterfront extends AppCompatActivity {
    DBHelper DB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caudanwaterfront);

        DB = new DBHelper(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        double height = displayMetrics.heightPixels;

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.imageDescription);
        double text = relativeLayout.getHeight();
        CardView cardView = (CardView) findViewById(R.id.imageContent);
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        height = height - 900;
        layoutParams.height = (int) height;
        cardView.setLayoutParams(layoutParams);

        CheckBox fav5 = findViewById(R.id.favourite5);
        fav5.setOnClickListener(new View.OnClickListener() {
            String username = readUsername("username.txt");


            @Override
            public void onClick(View v) {
                if(!fav5.isChecked()) {
                    DB.addToFavourite(username,"caudan_waterfront=4");
                    fav5.setButtonDrawable(R.drawable.baseline_favorite_border_24);
                }else {
                    DB.removeFromFav(username,"caudan_waterfront=4");
                    fav5.setButtonDrawable(R.drawable.heart_red);
                }
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