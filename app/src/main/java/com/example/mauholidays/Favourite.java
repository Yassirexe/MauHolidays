package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Favourite extends AppCompatActivity {

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        DB = new DBHelper(this);

        String user = readUsername("username.txt");
        if(user.equals("")) {
            user = "Guest";
        }

        ArrayList<String> fav1 = new ArrayList<>();
        fav1 = DB.getFavourite(user);
//        fav1.add(" ");
//        fav1.add("caudanonly_4");
//        fav1.add("lacroissetteonly_3");
//        fav1.add("caudanonly_2");
//        fav1.add("lacroissetteonly_1");
//        fav1.add("caudanonly_5");
//        fav1.add("lacroissetteonly_1");
//        fav1.add("caudanonly_2");
//        fav1.add("lacroissetteonly_2");
//        fav1.add("caudanonly_1");
//        fav1.add("lacroissetteonly_5");
        String fav = "";
        int star = 1;
        String txtstar ="1";

        String packageName = getPackageName();

        int arraySize = fav1.size();

        if(arraySize>0) {
            //String[] imgname = {" ","caudanonly","lacroissetteonly","caudanonly","lacroissetteonly","caudanonly","lacroissetteonly","caudanonly"};
            for (int i = 1; i < arraySize; i++) {

                fav = String.valueOf(fav1.get(i).split("_")[0]);
                Log.i(TAG, "onCreate: " + fav);

                try {
                    txtstar = fav1.get(i).split("_")[1];
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
                checkBox.setChecked(false);
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
                //String desc = mDrawableName;
                TextView textView = new TextView(this);
                textView.setText(mDrawableName);
                textView.setTextSize(18f);
                if (i > 1) {
                    layoutParams.addRule(RelativeLayout.BELOW, (100 + i - 1));
                    layoutParams.topMargin = 50;
                }
                textView.setShadowLayer(5, 1, 1, Color.GRAY);
//            layoutParams.width = 1200;
//            layoutParams.height =200;
                relativeLayout.addView(favFrame, layoutParams);
                layoutParams2.width = 220;
                layoutParams2.height = 220;
                layoutParams2.setMargins(40, 50, 500, 30);
                layoutParams2.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                favFrame.addView(img, layoutParams2);
                layoutParams3.width = 350;
                layoutParams3.setMargins(460, 80, 0, 0);
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


                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (checkBox.isChecked()) {
                            checkBox.setButtonDrawable(R.drawable.heart_white);
                            Log.i(TAG, "onClick: i haver id " + mDrawableName);
                        } else {
                            checkBox.setButtonDrawable(R.drawable.heart_red);
                        }

                    }
                });

            }
        }

        TextView homeScreen = (TextView) findViewById(R.id.homescreen1);

        homeScreen.setOnClickListener(new View.OnClickListener() {
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