package com.logistics.jubao.videodemo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class VideoBean implements Serializable{
    private String name;
    private String videoPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public VideoBean(String name, String videoPath) {
        this.name = name;
        this.videoPath = videoPath;
    }
}
