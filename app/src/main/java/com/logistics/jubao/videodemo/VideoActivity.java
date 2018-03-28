package com.logistics.jubao.videodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class VideoActivity extends AppCompatActivity {
    private VideoBean videoBean;
    private VideoView videoView;
    private int count;
    private static final int MAX_ERROW_COUNT = 5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initData();
        initView();
        initVitamio();
    }


    private void initView() {
        videoView = findViewById(R.id.video_view);
    }

    private void initData() {
        videoBean = (VideoBean) getIntent().getSerializableExtra("video");
    }

    private void initVitamio() {
        Vitamio.isInitialized(getApplicationContext());
        videoView.setVideoURI(Uri.parse(videoBean.getVideoPath()));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(VideoActivity.this, "视频准备完毕", Toast.LENGTH_SHORT).show();
                videoView.start();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
//                if (count > MAX_ERROW_COUNT) {
                Toast.makeText(VideoActivity.this, "视频获取失败，请尝试其他视频", Toast.LENGTH_SHORT).show();
                videoView.stopPlayback();
                finish();
//                } else {
//                    videoView.stopPlayback();
//                    videoView.setVideoURI(Uri.parse(videoBean.getVideoPath()));
//                }
//                count++;
                return false;
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoView.setVideoURI(Uri.parse(videoBean.getVideoPath()));
    }
}
