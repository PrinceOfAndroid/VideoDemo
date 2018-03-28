package com.logistics.jubao.videodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView reVideo;

    private List<VideoBean> videoBeen;
    private VideoItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }


    private void initData() {
        videoBeen = new ArrayList<>();
        videoBeen.add(new VideoBean("武林外传", "http://183.251.61.207/PLTV/88888888/224/3221225836/index.m3u8"));
        videoBeen.add(new VideoBean("武林外传", "http://183.251.61.207/PLTV/88888888/224/3221225845/index.m3u8"));
        videoBeen.add(new VideoBean("武林外传", "http://183.251.61.207/PLTV/88888888/224/3221225846/index.m3u8"));
        videoBeen.add(new VideoBean("武林外传", "http://183.251.61.207/PLTV/88888888/224/3221225832/index.m3u8"));
        videoBeen.add(new VideoBean("武林外传", "http://183.251.61.207/PLTV/88888888/224/3221225831/index.m3u8"));
    }

    private void initView() {
        reVideo = findViewById(R.id.re_video);
        adapter = new VideoItemAdapter(R.layout.re_video_item, videoBeen);
        reVideo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        reVideo.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("video",videoBeen.get(position));
                startActivity(intent);
            }
        });
    }


}
