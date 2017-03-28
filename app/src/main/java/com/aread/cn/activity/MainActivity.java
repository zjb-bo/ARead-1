package com.aread.cn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aread.cn.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(MainActivity.this)
                        .withText("一念收集，定制您的人生流年！")
                        .withMedia(new UMImage(MainActivity.this,R.mipmap.a_read_logo))
                        .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.SINA,SHARE_MEDIA.YNOTE,SHARE_MEDIA.EVERNOTE)
                        .setCallback(umShareListener)
                        .open();
            }
        });
        findViewById(R.id.btnqq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
            }
        });
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this, share_media+"开始授权...", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(MainActivity.this, share_media+"授权成功...", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Toast.makeText(MainActivity.this,  share_media+"授权失败...", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText(MainActivity.this,  share_media+"授权取消...", Toast.LENGTH_SHORT).show();

        }
    };

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this, share_media+"开始分享...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this, share_media+"分享成功...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Toast.makeText(MainActivity.this,  share_media+"分享失败...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this,  share_media+"分享取消...", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
