package com.example.mauholidays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class videoMain extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<Video> videoList;
    private VideoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_main);

        videoList = new ArrayList<>();
        viewPager2 = findViewById(R.id.viewPagerVideos);

        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video , "Mauritius", "places in Mauritius"));
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.videom , "Mauritius", "visit to Mauritius"));
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.videon , "Island", "Beauty Of Mauritius"));

        adapter = new VideoAdapter(videoList);
        viewPager2.setAdapter(adapter);
    }
}