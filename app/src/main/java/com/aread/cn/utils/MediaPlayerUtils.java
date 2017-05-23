package com.aread.cn.utils;

import android.media.MediaPlayer;
import android.text.TextUtils;

import java.io.IOException;

/**
 * Created by bobo on 2017/5/7.
 */

public class MediaPlayerUtils {
    private static MediaPlayer mediaPlayer;
    public static void mediaPlayerStart(String dataPath){
        if(TextUtils.isEmpty(dataPath))return;
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(dataPath);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.pause();
                    mp.release();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getMediaPlayProgress(){
        int progress = 0;
        if(mediaPlayer == null)return progress;
        try {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration = mediaPlayer.getDuration();
            LogUtils.e("zjb--->getMediaPlayProgress:"+currentPosition+" duration:"+duration);
            if(duration != 0 || duration != -1){
                progress = currentPosition*10000/duration;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return progress;
    }
}
