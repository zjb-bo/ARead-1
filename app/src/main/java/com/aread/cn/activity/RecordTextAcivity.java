package com.aread.cn.activity;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityRecordtextBinding;
import com.aread.cn.utils.LogUtils;
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
        recordtextBinding.imgRecorder.setOnClickListener(this);
        recordtextBinding.play.setOnClickListener(this);
        recordtextBinding.title.titleLeft.setOnClickListener(this);
        recordtextBinding.title.titleRight.setOnClickListener(this);
        recordtextBinding.imgRecorder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
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
        recordtextBinding.time.setText("00:00");
        mHandler.sendEmptyMessageDelayed(0,0);
    }

    private void stopRecorderCount(){
        progressTime  = recorderTimeCount;
        recorderTimeCount = 0;
        mHandler.removeMessages(0);
    }


    private int showRecorderPage = 0,showRecorderText = 1;
    private boolean isRecorderNotPlay = true;
    private void showRecorderBanner(int show){
        if(show == showRecorderPage){
            isRecorderNotPlay = true;
            RecorderUtils.start_record();
            startRecorderCount();
        }else if(show == showRecorderText){
            isRecorderNotPlay = false;
            RecorderUtils.stop_record();
            stopRecorderCount();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                    playRecorder();
                break;
            case R.id.title_left:
                RecorderUtils.cancleSaveRecoderFile();
                finish();
                break;
            case R.id.title_Right:
                break;
        }
    }


    private int progressTime = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int mediaPlayProgress = MediaPlayerUtils.getMediaPlayProgress();
            mHandler.removeMessages(0);
            handler.sendEmptyMessageDelayed(0,50);
            if(mediaPlayProgress == 0)return;
            LogUtils.e("zjb--->playRecorder:"+mediaPlayProgress);
            recordtextBinding.progressBar.setProgress(mediaPlayProgress);
        }
    };
    private void playRecorder(){
        if(RecorderUtils.send_sound_file == null)return;
        MediaPlayerUtils.mediaPlayerStart(RecorderUtils.send_sound_file.getAbsolutePath());
        handler.sendEmptyMessageDelayed(0,50);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        RecorderUtils.cancleSaveRecoderFile();
    }
}
