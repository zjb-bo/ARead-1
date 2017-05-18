package com.aread.cn.activity;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
//        recordtextBinding.cancel.setOnClickListener(this);
//        recordtextBinding.sure.setOnClickListener(this);
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
        mHandler.removeMessages(0);
        recorderTimeCount = 0;

    }


    private int showRecorderPage = 0,showRecorderText = 1;
    private boolean isRecorderNotPlay = true;
    private void showRecorderBanner(int show){
        if(show == showRecorderPage){
            isRecorderNotPlay = true;
//            recordtextBinding.textBanner.setVisibility(View.INVISIBLE);
//            recordtextBinding.recorderPage.setVisibility(View.VISIBLE);
//            recordtextBinding.imgRecorder.setImageResource(R.mipmap.diary_audio_input_btn);
            RecorderUtils.start_record();
            startRecorderCount();
        }else if(show == showRecorderText){
            isRecorderNotPlay = false;
//            recordtextBinding.textBanner.setVisibility(View.VISIBLE);
//            recordtextBinding.recorderPage.setVisibility(View.INVISIBLE);
//            recordtextBinding.imgRecorder.setImageResource(R.mipmap.btn_play);
            RecorderUtils.stop_record();
            stopRecorderCount();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.cancel:
//                isRecorderNotPlay = true;
////                recordtextBinding.imgRecorder.setImageResource(R.mipmap.diary_audio_input_btn);
//                RecorderUtils.cancleSaveRecoderFile();
//                RecorderUtils.stop_record();
//                break;
//            case R.id.sure:
//                finish();
//                break;
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


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String mediaPlayProgress = MediaPlayerUtils.getMediaPlayProgress();
            if(TextUtils.isEmpty(mediaPlayProgress))return;
//            recordtextBinding.imgRecorder.setCurrentProgress(new Float(mediaPlayProgress));
            recordtextBinding.progressBar.setProgress(Integer.parseInt(mediaPlayProgress));
            handler.sendEmptyMessageDelayed(0,100);
        }
    };
    private void playRecorder(){
        MediaPlayerUtils.mediaPlayerStart(RecorderUtils.send_sound_file.getAbsolutePath());
//        recordtextBinding.imgRecorder.setAllProgress(100);
        handler.sendEmptyMessageDelayed(0,100);
    }
}
