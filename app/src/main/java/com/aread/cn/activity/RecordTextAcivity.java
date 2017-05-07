package com.aread.cn.activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityRecordtextBinding;
import com.aread.cn.utils.MediaPlayerUtils;
import com.aread.cn.utils.RecorderUtils;
import com.aread.cn.utils.StringUtils;

/**
 * Created by bobo on 2017/4/4.
 */

public class RecordTextAcivity extends BaseActivity implements View.OnClickListener {
    private ActivityRecordtextBinding recordtextBinding;
    @Override
    protected int setView() {
        return R.layout.activity_recordtext;
    }

    @Override
    protected void initData() {
        recordtextBinding = (ActivityRecordtextBinding) viewDataBinding;
        recordtextBinding.cancel.setOnClickListener(this);
        recordtextBinding.sure.setOnClickListener(this);
        recordtextBinding.imgRecorder.setOnClickListener(this);
        recordtextBinding.imgRecorder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!isRecorderNotPlay)return false;
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showRecorderBanner(showRecorderPage);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        showRecorderBanner(showRecorderText);
                        break;
                }
                return true;
            }
        });
    }


    private int recorderTimeCount = 0;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    recordtextBinding.time.setText(StringUtils.recorderTimeCount(recorderTimeCount++));
                    break;
            }
            mHandler.sendEmptyMessageDelayed(0,1000);
        }
    };

    private void startRecorderCount(){
        mHandler.sendEmptyMessageDelayed(0,0);
    }

    private void stopRecorderCount(){
        mHandler.removeMessages(0);
        recorderTimeCount = 0;
    }


    private int showRecorderPage = 0,showRecorderText = 1;
    private boolean isRecorderNotPlay = true;
    private void showRecorderBanner(int show){
        if(show == showRecorderPage){
            isRecorderNotPlay = true;
            recordtextBinding.textBanner.setVisibility(View.INVISIBLE);
            recordtextBinding.recorderPage.setVisibility(View.VISIBLE);
            recordtextBinding.imgRecorder.setImageResource(R.mipmap.diary_audio_input_btn);
            RecorderUtils.start_record();
            startRecorderCount();
        }else if(show == showRecorderText){
            isRecorderNotPlay = false;
            recordtextBinding.textBanner.setVisibility(View.VISIBLE);
            recordtextBinding.recorderPage.setVisibility(View.INVISIBLE);
            recordtextBinding.imgRecorder.setImageResource(R.mipmap.btn_play);
            RecorderUtils.stop_record();
            stopRecorderCount();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                RecorderUtils.cancleSaveRecoderFile();
                break;
            case R.id.sure:
                finish();
                break;
            case R.id.img_recorder:
                if(!isRecorderNotPlay){
                    MediaPlayerUtils.mediaPlayerStart(RecorderUtils.send_sound_file.getAbsolutePath());
                }
                break;
        }
    }
}
