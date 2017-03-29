package com.aread.cn.activity;

import android.content.Intent;
import android.view.View;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.utils.UmengLoginShareUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }
    @Override
    protected void initData() {
        findViewById(R.id.btnqq).setOnClickListener(this);
        findViewById(R.id.btnwb).setOnClickListener(this);
        findViewById(R.id.btnwx).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnqq:
                UmengLoginShareUtils.getInstance(MainActivity.this).thirdLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.btnwb:
                UmengLoginShareUtils.getInstance(MainActivity.this).thirdLogin(SHARE_MEDIA.SINA);
                break;
            case R.id.btnwx:
                UmengLoginShareUtils.getInstance(MainActivity.this).thirdLogin(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.button:
                UmengLoginShareUtils.getInstance(MainActivity.this).shareOpen("");
                break;
        }
    }
}
