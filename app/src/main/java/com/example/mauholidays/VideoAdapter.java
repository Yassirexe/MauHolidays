package com.example.mauholidays;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<Video> videoList;

    public VideoAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostvideo, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoList.get(position));

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView title, desc;
        public VideoViewHolder(@NonNull View itemView){
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            title = itemView.findViewById(R.id.txtTitle);
            desc = itemView.findViewById(R.id.txtDesc);

        }

        public void setVideoData(Video video) {
            title.setText(video.getTitle());
            desc.setText(video.getDesc());
            videoView.setVideoPath(video.getURL());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    CheckBox likebox = itemView.findViewById(R.id.like);
                    likebox.setButtonDrawable(R.drawable.baseline_favorite_24);
                    likebox.setChecked(false);

                    float videoRatio =mp.getVideoWidth()/ (float) mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if(scale >= 1f) {
                        videoView.setScaleX(scale);
                    } else {
                        videoView.setScaleY(1f/scale);
                    }

                    ImageView imgPause = itemView.findViewById(R.id.pauseIcon);



                    likebox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(likebox.isChecked()) {
                                likebox.setButtonDrawable(R.drawable.baseline_favorite_24);
                            }else{
                                likebox.setButtonDrawable(R.drawable.baseline_favorite_red);
                            }
                        }
                    });

                    itemView.findViewById(R.id.videoView).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mp.isPlaying()) {
                                mp.pause();
                                imgPause.setImageResource(R.drawable.baseline_pause_24);
                            }else{
                                mp.start();
                                imgPause.setImageDrawable(null);
                            }
                        }
                    });
                }
            });


            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {



                    mp.start();

                    itemView.findViewById(R.id.videoView).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mp.isPlaying()) {
                                mp.pause();
                            }else{
                                mp.start();
                            }
                        }
                    });

                }
            });

        }
    }
}

