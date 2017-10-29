package com.pawel.mplay;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlay extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private int poosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        videoView=(VideoView) findViewById(R.id.video_view);

        if (mediaController==null){
            mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }
        Intent intent = getIntent();
        if (intent != null){
            String path = intent.getStringExtra("video_to_play");
            videoView.setVideoURI(Uri.parse(path));
            if (videoView.isPlaying()){
                videoView.start();
            }

        }
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(poosition);
                if(poosition==0){
                    videoView.start();
                }

            mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                    mediaController.setAnchorView(videoView);
                }
            });
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curent_position",videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        poosition= savedInstanceState.getInt("curent_position",0);
        videoView.seekTo(poosition);
    }
}
