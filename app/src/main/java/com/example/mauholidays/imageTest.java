package com.example.mauholidays;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class imageTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test);
        String packageName = getPackageName();
        String mDrawableName = "caudan_frame";
        int resId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        String[] imgname = {" ","caudan_frame","lacroisette","capmal","casela","caudan_frame"};


        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.RelativeLayout01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        relativeLayout2.setMinimumWidth(300);

        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );


        for(int i =1;i<imgname.length;i++) {
            ImageView imgnames = new ImageView(this);
            mDrawableName = imgname[i];
            resId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
            imgnames.setId(i);
            imgnames.setImageResource(resId);
            imgnames.setMinimumWidth(1200);
            imgnames.setMinimumHeight(500);
            layoutParams2 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            if(i>1) {
                layoutParams2.addRule(RelativeLayout.BELOW, (i-1));
            }
            relativeLayout2.addView(imgnames, layoutParams2);
        }

        //int resId = getResources().getIdentifier(imangeName, "string", packageName);
        ImageView imageView = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.homebuscat_1);
        imageView.setImageResource(R.drawable.caudan_frame);
        imageView.setMinimumWidth(1200);
        imageView.setMinimumHeight(500);
        imageView.setId(9);
        imageView2.setMinimumWidth(1200);
        imageView2.setMinimumHeight(500);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout01);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
        //relativeLayout.setMinimumWidth(300);
//        layoutParams.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //relativeLayout.addView(imageView, layoutParams);
//        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.RelativeLayout01);
//        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
        //relativeLayout.setMinimumWidth(300);
//        layoutParams2.addRule(RelativeLayout.BELOW, 1);
//        relativeLayout.addView(imageView2, layoutParams2);


        //............................//
        // Create a reference to "mountains.jpg"
        // File or Blob
        //FirebaseStorage storage = FirebaseStorage.getInstance();
        //StorageReference storageRef = storage.getReferenceFromUrl("gs://mobileapptourist.appspot.com");    //change the url acco





    }
}