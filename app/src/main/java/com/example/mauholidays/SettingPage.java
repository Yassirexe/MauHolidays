package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingPage extends AppCompatActivity {

    //declare variables
    EditText username, password, repassword;
    Button signup, signin, Edit;
    DBHelper DB;
    ImageView privacy, helpsetting, about,logout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingpage);

        //initialise variables
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        Edit = (Button) findViewById(R.id.buttonEdit);
        privacy = (ImageView) findViewById(R.id.buttonPrivacy);
        helpsetting = (ImageView) findViewById(R.id.buttonHelp);
        about = (ImageView) findViewById(R.id.buttonAbout);

        DB = new DBHelper(this);

        //listeners for buttons


        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SettingPage.this, EditProfile.class);
                startActivity(intent);
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SettingPage.this, PrivacyPolicy.class);
                startActivity(intent);
            }
        });
        helpsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SettingPage.this, HelpSetting.class);
                startActivity(intent);
            }

        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SettingPage.this, about.class);
                startActivity(intent);
            }

        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logout();
            }
            private void logout() {
                Intent intent = new Intent(SettingPage.this,LogOut.class);
                startActivity(intent);
                finish();
            }
        });

    }
}















