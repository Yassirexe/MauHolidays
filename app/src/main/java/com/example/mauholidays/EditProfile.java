package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditProfile extends AppCompatActivity {

    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editingprofile);

        DB = new DBHelper(this);

        TextView editProfileUsername = (TextView) findViewById(R.id.editProfileUserName);
        String username = readUsername("username.txt");

        editProfileUsername.setText(username);


        Button submitButton = findViewById(R.id.editSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameField = (EditText) findViewById(R.id.username);
                String usernameValue = usernameField.getText().toString();
                EditText passwordField = (EditText) findViewById(R.id.password);
                String passwordValue = passwordField.getText().toString();

                writeTofile("username.txt",usernameValue);
                boolean result = DB.updateProfile(username, passwordValue, usernameValue);

                if(result) {
                    editProfileUsername.setText(usernameValue);
                    Toast.makeText(EditProfile.this, "Profile updated successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EditProfile.this, "Profile failed!", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.backFromEditProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this, SettingPage.class);
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