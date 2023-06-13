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
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;

public class SettingPage extends AppCompatActivity {

    //declare variables
    EditText username, password, repassword;
    Button signup, signin, Edit;
    DBHelper DB;
    ImageView privacy, helpsetting, about;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingpage);

        //initialise variables
//        username = (EditText) findViewById(R.id.username);
//        password = (EditText) findViewById(R.id.password);
//        repassword = (EditText) findViewById(R.id.repassword);
//        signup = (Button) findViewById(R.id.btnsignup);
//        signin = (Button) findViewById(R.id.btnsignin);
        Edit = (Button) findViewById(R.id.buttonEdit);
        privacy = (ImageView) findViewById(R.id.buttonPrivacy);
        helpsetting = (ImageView) findViewById(R.id.buttonHelp);
        about = (ImageView) findViewById(R.id.buttonAbout);

        DB = new DBHelper(this);

        //listeners for buttons




        String username = readUsername("username.txt");
        TextView UserTitle = (TextView) findViewById(R.id.settingUserName);
        UserTitle.setText(username);
        Button goToEdit = findViewById(R.id.buttonEdit);
        goToEdit.setOnClickListener(new View.OnClickListener() {
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
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                logout();
//            }
//            private void logout() {
//                Intent intent = new Intent(SettingPage.this,LogOut.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//        logout
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = getFilesDir();
                File file = new File(dir, "username.txt");
                boolean deleted = file.delete();
                if(deleted) {
                    Intent intent = new Intent(SettingPage.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

//        Button navbar

        findViewById(R.id.exploreScreen4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, videoMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.homescreen4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, Home.class);
                startActivity(intent);
            }
        });

        TextView favScreen = (TextView) findViewById(R.id.favscreen4);

        favScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, Favourite.class);
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




