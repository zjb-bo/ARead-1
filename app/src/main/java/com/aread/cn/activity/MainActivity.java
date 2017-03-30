package com.aread.cn.activity;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity{
    private ActivityMainBinding mainBinding;

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }
    @Override
    protected void initData() {
        mainBinding = (ActivityMainBinding) viewDataBinding;
    }



//      Umeng必须做的回调
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }
}
