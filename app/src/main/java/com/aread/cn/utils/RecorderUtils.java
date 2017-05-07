package com.aread.cn.utils;

import android.icu.text.MessageFormat;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.Date;

/**
 * Created by bobo on 2017/5/6.
 */

public class RecorderUtils {

    private static MediaRecorder recorder;
    public static File send_sound_file;
    private static final String recoderPath = Environment.getExternalStorageDirectory() + "/Aread/talk/send";

    // 开始录音
    public static void start_record() {
        if (!Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            Log.e("zjb", "startRecoder:-->SD卡不存在,请插入SD卡!");
        } else {
            try {
                // 获取当前时间
                // 创建保存录音的音频文件
                send_sound_file = new File(recoderPath);
                // 如果目录不存在
                if (!send_sound_file.exists()) {
                    send_sound_file.mkdirs();
                }
                send_sound_file = new File(send_sound_file.getPath()+System.currentTimeMillis() + ".amr");
                recorder = new MediaRecorder();
                // 设置录音的声音来源
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                // 设置录制的声音的输出格式（必须在设置声音编码格式之前设置）
                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                // 设置声音编码的格式
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                recorder.setOutputFile(send_sound_file.getAbsolutePath());
                recorder.prepare();
                // 开始录音
                recorder.start();
            } catch (Exception e) {
                Log.e("zjb", "startRecoder:-->"+e.toString());
            }
        }
    }

    // 停止录音
    public static void stop_record() {
        if (send_sound_file != null && send_sound_file.exists() && recorder!= null) {
           try {
               // 停止录音
               recorder.stop();
               // 释放资源
               recorder.release();
               recorder = null;
           }catch (Exception e){
                e.printStackTrace();
           }
        }
    }

    //不保存录音文件
    public static void cancleSaveRecoderFile(){
        if(send_sound_file != null && send_sound_file.isFile()){
            send_sound_file.delete();
        }
    }

}
