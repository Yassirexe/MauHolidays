package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

            }
        });
    }
}