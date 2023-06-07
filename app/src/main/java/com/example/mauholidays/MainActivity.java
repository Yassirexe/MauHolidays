package com.example.mauholidays;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< Updated upstream
=======
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;

>>>>>>> Stashed changes
public class MainActivity extends AppCompatActivity {

    //declare variables
    EditText username, password, repassword;
    Button signup, signin, Edit;
    DBHelper DB;
    ImageView privacy, helpsetting, about;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(MainActivity.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertdata(user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                //  Intent intent = new Intent(getApplicationContext(), Home.class);
                                //  startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User already found , Please Sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
<<<<<<< Updated upstream
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, EditProfile.class);
                startActivity(intent);
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PrivacyPolicy.class);
                startActivity(intent);
            }
        });
        helpsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, HelpSetting.class);
                startActivity(intent);
=======
                return false;


>>>>>>> Stashed changes
            }

        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
            }

<<<<<<< Updated upstream
        });
    }
}










=======



    }

    private SQLiteDatabase getSupportFragmentManager() {
    }


}
>>>>>>> Stashed changes
