package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Favourite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        ArrayList<String> fav = new ArrayList<>();
        fav.add(" ");
        fav.add("caudanonly");
        fav.add("lacroissetteonly");
        fav.add("caudanonly");
        fav.add("lacroissetteonly");
        fav.add("caudanonly");
        fav.add("lacroissetteonly");
        fav.add("caudanonly");
        fav.add("lacroissetteonly");
        fav.add("caudanonly");
        fav.add("lacroissetteonly");

        String packageName = getPackageName();

        int arraySize = fav.size();

        //String[] imgname = {" ","caudanonly","lacroissetteonly","caudanonly","lacroissetteonly","caudanonly","lacroissetteonly","caudanonly"};
        for(int i =1;i< arraySize;i++) {

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            RelativeLayout.LayoutParams layoutParams3= new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            RelativeLayout.LayoutParams layoutParams4= new RelativeLayout.LayoutParams(
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

            int frameid = 100+i;
            favFrame.setId(frameid);
            ImageView img = new ImageView(this);
            String mDrawableName = fav.get(i);
            int resId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
            img.setImageResource(resId);
            //String desc = mDrawableName;
            TextView textView = new TextView(this);
            textView.setText(mDrawableName);
            textView.setTextSize(18f);
            if(i>1) {
                layoutParams.addRule(RelativeLayout.BELOW, (100+i-1));
                layoutParams.topMargin = 50;
            }
            textView.setShadowLayer(5, 1, 1, Color.GRAY);
//            layoutParams.width = 1200;
//            layoutParams.height =200;
            relativeLayout.addView(favFrame, layoutParams);
            layoutParams2.width = 220;
            layoutParams2.height =220;
            layoutParams2.setMargins(40,50,500,30);
            layoutParams2.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            favFrame.addView(img,layoutParams2);
            layoutParams3.width = 350;
            layoutParams3.setMargins(460,80,0,0);
            favFrame.addView(textView,layoutParams3);
            layoutParams4.setMargins(650,160,50,20);
            favFrame.addView(checkBox,layoutParams4);


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
}