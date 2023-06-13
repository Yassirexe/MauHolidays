package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import com.example.mauholidays.Home;
//import com.example.mauholidays.R;

public class LoginActivity extends AppCompatActivity {

    //declaring variables
    EditText username, password;
    Button btnlogin;
    DBHelper DB;

    Button noaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialise variables
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        noaccount = (Button) findViewById(R.id.noaccount1);

        DB = new DBHelper(this);

        noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, signup.class);
                startActivity(intent);
            }
        });


        //listeners for buttons
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please fill all the fieds", Toast.LENGTH_SHORT).show();

                else {
                    Boolean checkuserpass = DB.checkuserpassword(user, pass);
                    if(checkuserpass == true){
                        writeTofile("username.txt",user);
                        Toast.makeText(LoginActivity.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, Home.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }


        });

    }


    public void writeTofile(String fileName, String nameofuser) {
        try {
            File path = getApplicationContext().getFilesDir();
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            try {
                writer.write(nameofuser.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}