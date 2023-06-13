package com.example.mauholidays;

public class Video {

    public String videoURL,videoTitle,videoDesc;

    public Video(String videoURL, String videoTitle, String videoDesc) {
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
        this.videoDesc = videoDesc;
    }
    public String getURL() {
        return videoURL;
    }

    public String getTitle() {
        return videoTitle;
    }

    public String getDesc() {
        return videoDesc;
    }

}
