package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;

public class club_banana extends AppCompatActivity {

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_banana);

        DB = new DBHelper(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        double height = displayMetrics.heightPixels;

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.imageDescription);
        double text = relativeLayout.getHeight();
        CardView cardView = (CardView) findViewById(R.id.imageContent);
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        height = height - 1000;
        layoutParams.height = (int) height;
        cardView.setLayoutParams(layoutParams);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        String username = readUsername("username.txt");
        CheckBox fav5 = (CheckBox) findViewById(R.id.favourite5);

        boolean isFav = DB.getInfo(username,"banana_club-5");
        if(isFav) {
            fav5.setChecked(true);
            fav5.setButtonDrawable(R.drawable.baseline_favorite_red);
        } else {
            fav5.setChecked(false);
            fav5.setButtonDrawable(R.drawable.baseline_favorite_border_24);
        }

        fav5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(fav5.isChecked()) {
                    DB.addToFavourite(username,"banana_club-5");
                    fav5.setButtonDrawable(R.drawable.heart_red);
                    Toast.makeText(club_banana.this, "Added to favourite", Toast.LENGTH_SHORT).show();
                }else {
                    DB.removeFromFav(username,"banana_club-5");
                    fav5.setButtonDrawable(R.drawable.baseline_favorite_border_24);
                    Toast.makeText(club_banana.this, "Removed favourite", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(club_banana.this, all_nature.class);
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