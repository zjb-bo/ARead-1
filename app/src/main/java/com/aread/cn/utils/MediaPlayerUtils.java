package com.aread.cn.utils;

import android.media.MediaPlayer;
import android.text.TextUtils;

import java.io.IOException;

/**
 * Created by bobo on 2017/5/7.
 */

public class MediaPlayerUtils {

    public static void mediaPlayerStart(String dataPath){
        if(TextUtils.isEmpty(dataPath))return;
            MediaPlayer mediaPlayer = new MediaPlayer();
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
}
