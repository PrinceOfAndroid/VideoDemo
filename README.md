# VideoDemo
vitamio视频播放demo

## 使用流程
* 下载vitamio库，拷贝src下java文件以及资源文件到library中，拷贝so文件到项目目录，添加依赖，进行编译。
* 添加如下的 manifest 配置：
``` 
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    
     <activity
            android:name="io.vov.vitamio.activity.InitActivity"
            android:configChanges="orientation|screenSize|smallestScreenSize|keyboard|keyboardHidden|navigation"
            android:launchMode="singleTop"
            android:theme="@android:style/Theme.NoTitleBar"
            android:windowSoftInputMode="stateAlwaysHidden" />
```
* 添加播放 java 代码
```
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
                Toast.makeText(VideoActivity.this, "视频获取失败，请尝试其他视频", Toast.LENGTH_SHORT).show();
                videoView.stopPlayback();
                finish();
                return false;
            }
        });
    }
```
