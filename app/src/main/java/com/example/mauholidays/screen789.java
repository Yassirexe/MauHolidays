package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class screen789 extends AppCompatActivity {
    private Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen789);


        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen789.this,screen10.class);
                startActivity(intent);
            }
        });








        b1 = findViewById(R.id.quizsubmit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setText("Next");
                RadioButton r1 = findViewById(R.id.first);
                RadioButton r2 = findViewById(R.id.second);
                RadioButton r3 = findViewById(R.id.third);
                RadioButton r4 = findViewById(R.id.fourth);
                if(r1.isChecked()) {
                    r1.setTextColor(Color.RED);
                } else if(r2.isChecked()) {
                    r2.setTextColor(Color.RED);
                } else if(r3.isChecked()) {
                    r3.setTextColor(Color.GREEN);
                } else {
                    r4.setTextColor(Color.RED);
                }

               // scrollView.setScrollY(0);



            RadioButton radioButton1 = findViewById(R.id.mascarene);
            RadioButton radioButton2 = findViewById(R.id.cirne);
            RadioButton radioButton3 = findViewById(R.id.mauritius);
            RadioButton radioButton4 = findViewById(R.id.brandon);
                if(radioButton1.isChecked()) {
                radioButton1.setTextColor(Color.RED);
            } else if(radioButton2.isChecked()) {
                radioButton2.setTextColor(Color.RED);
            } else if(radioButton3.isChecked()) {
                radioButton3.setTextColor(Color.GREEN);
            } else {
                radioButton4.setTextColor(Color.RED);
            }

            // scrollView.setScrollY(0);


            RadioButton radio1 = findViewById(R.id.A);
            RadioButton radio2 = findViewById(R.id.B);
            RadioButton radio3 = findViewById(R.id.C);
            RadioButton radio4 = findViewById(R.id.D);
                if(radio1.isChecked()) {
                radio1.setTextColor(Color.GREEN);
            } else if(radio2.isChecked()) {
                radio2.setTextColor(Color.RED);
            } else if(radioButton3.isChecked()) {
                radio3.setTextColor(Color.RED);
            } else {
                radio4.setTextColor(Color.RED);
            }

            // scrollView.setScrollY(0);


            RadioButton Radio1 = findViewById(R.id.one);
            RadioButton Radio2 = findViewById(R.id.two);
            RadioButton Radio3 = findViewById(R.id.three);
            RadioButton Radio4 = findViewById(R.id.four);
                if(Radio1.isChecked()) {
                Radio1.setTextColor(Color.RED);
            } else if(Radio2.isChecked()) {
                Radio2.setTextColor(Color.RED);
            } else if(Radio3.isChecked()) {
                Radio3.setTextColor(Color.GREEN);
            } else {
                Radio4.setTextColor(Color.RED);
            }

            // scrollView.setScrollY(0);



            RadioButton Button1 = findViewById(R.id.questionfivea);
            RadioButton Button2 = findViewById(R.id.questionfiveb);
            RadioButton Button3 = findViewById(R.id.questionfivec);
            RadioButton Button4 = findViewById(R.id.questionfived);
                if(Button1.isChecked()) {
                Button1.setTextColor(Color.RED);
            } else if(Button2.isChecked()) {
                Button2.setTextColor(Color.GREEN);
            } else if(Button3.isChecked()) {
                Button3.setTextColor(Color.RED);
            } else {
                Button4.setTextColor(Color.RED);
            }

            // scrollView.setScrollY(0);

            }

    });
    }
}