package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Favourite extends AppCompatActivity {

    DBHelper DB;
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        DB = new DBHelper(this);

        String user = readUsername("username.txt");
        if(user.equals("")) {
            user = "Guest";
        }
        Log.i(TAG, "user is : " + user);
        ArrayList<String> fav1 = new ArrayList<>();
        fav1 = DB.getFavourite(user);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int desiredWidth = (int) (screenWidth * 0.8);
        String fav = "";
        int star = 1;
        String txtstar ="1";
        String packageName = getPackageName();
        Log.i(TAG, "onCreate: " + fav1.get(0));

        //int arraySize = fav1.size();

        if(fav1.size()>1) {
            for (int i = 1; i < fav1.size() ; i++) {
                String dbName = fav1.get(i);
                    if (fav1.get(i).contains("-")) {
                        fav = String.valueOf(fav1.get(i).split("-")[0]);
                        Log.i(TAG, "onCreate: " + fav);
                    } else {
                        fav = fav1.get(i);
                        Log.i(TAG, "else part onCreate: " + fav);

                    }
                    Log.i(TAG, "onCreate: " + fav);
                    try {
                        txtstar = fav1.get(i).split("-")[1];
                        star = Integer.parseInt(txtstar);
                        Log.i(TAG, "onCreate: " + txtstar);
                    } catch (Exception e) {

                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    RelativeLayout.LayoutParams layoutParamsStar = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );
                    RelativeLayout.LayoutParams layoutParamsLinear = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                    );

                    CheckBox checkBox = new CheckBox(this);
                    checkBox.setChecked(true);
                    checkBox.setButtonDrawable(R.drawable.heart_red);
                    checkBox.setId(i);
                    checkBox.setScaleY(1.3f);
                    checkBox.setScaleX(1.3f);
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.favScroll);
                    RelativeLayout favFrame = new RelativeLayout(this);
                    favFrame.setBackgroundResource(R.drawable.favframephone);

                    int frameid = 100 + i;
                    favFrame.setId(frameid);
                    ImageView img = new ImageView(this);
                    String mDrawableName = fav;
                    int resId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
                    img.setImageResource(resId);
                    fav = fav.replace("_", " ");
                    String placeName = fav.substring(0, 1).toUpperCase() + fav.substring(1);
                    TextView textView = new TextView(this);
                    textView.setText(placeName);
                    textView.setTextSize(18f);
                    if (i > 1) {
                        layoutParams.addRule(RelativeLayout.BELOW, (100 + i - 1));
                        layoutParams.topMargin = 50;
                    }
                    textView.setShadowLayer(5, 1, 1, Color.GRAY);
                    layoutParams.width = desiredWidth;
//            layoutParams.height =200;
                    relativeLayout.addView(favFrame, layoutParams);
                    layoutParams2.width = 220;
                    layoutParams2.height = 220;
                    layoutParams2.setMargins(40, 50, 500, 30);
                    layoutParams2.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                    favFrame.addView(img, layoutParams2);
                    layoutParams3.width = 350;
                    layoutParams3.topMargin = 80;
                    layoutParams3.leftMargin = (int) (desiredWidth * 0.8 * 0.8);
                    favFrame.addView(textView, layoutParams3);
                    layoutParams4.setMargins(650, 160, 50, 20);
                    favFrame.addView(checkBox, layoutParams4);

                    LinearLayout linearLayout = new LinearLayout(this);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                    //Adding star
                    for (int j = 0; j < star; j++) {
                        ImageView s = new ImageView(this);
                        s.setImageResource(R.drawable.baseline_star_24);
                        layoutParamsStar.width = 60;
                        layoutParamsStar.height = 60;
                        linearLayout.addView(s, layoutParamsStar);
                    }
                    layoutParamsLinear.setMargins(450, 180, 10, 20);
                    favFrame.addView(linearLayout, layoutParamsLinear);


                    String finalUser = user;
                    checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (checkBox.isChecked()) {
                                checkBox.setButtonDrawable(R.drawable.heart_red);
                                DB.addToFavourite(finalUser, dbName);
                                Toast.makeText(Favourite.this, "Add to favourite ", Toast.LENGTH_SHORT).show();
                            } else {

                                checkBox.setButtonDrawable(R.drawable.baseline_favorite_border_24);
                                DB.removeFromFav(finalUser, dbName);
                                Toast.makeText(Favourite.this, "Removed favourite ", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });


            }
        } else {
            //code if there are no favourites
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.sad);
            img.setId(9999);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.favScroll);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            int imgSize = (int) (screenWidth * 0.8);
            layoutParams.width = imgSize;
            relativeLayout.addView(img,layoutParams);
            TextView textNoFav = new TextView(this);
            textNoFav.setText("looks like your list is empty");
            textNoFav.setTextSize(24f);
            textNoFav.setTypeface(null, Typeface.BOLD);
            int textSize = (int) (screenWidth * 0.65);
            int textMargin = (int) (screenWidth * 0.2);
            layoutParams2.width = textSize;
            layoutParams2.leftMargin = textMargin;
            layoutParams2.topMargin = 50;
            layoutParams2.addRule(RelativeLayout.BELOW, 9999);
            relativeLayout.addView(textNoFav,layoutParams2);

        }


        findViewById(R.id.exploreScreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favourite.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profilescreen3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favourite.this, SettingPage.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.homescreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favourite.this, Home.class);
                startActivity(intent);
            }
        });


    }

    public String readUsername(String filePath) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, filePath);
        byte[] name = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(name);
            return new String(name);
        } catch (Exception e) {
            return new String("Guest");
        }

    }
}