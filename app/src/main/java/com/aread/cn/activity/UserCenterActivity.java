package com.aread.cn.activity;


import android.content.Intent;
import android.view.View;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityUsercenterBinding;

/**
 * Created by Administrator on 2017/5/25.
 */

public class UserCenterActivity extends BaseActivity {

    ActivityUsercenterBinding dataBinding = (ActivityUsercenterBinding) viewDataBinding;

    @Override
    protected int setView() {
        return R.layout.activity_usercenter;
    }

    @Override
    protected void initData() {
        dataBinding.userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserCenterActivity.this,TakePhotoActivity.class));
            }
        });
    }
}
