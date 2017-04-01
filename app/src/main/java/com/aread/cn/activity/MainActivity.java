package com.aread.cn.activity;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;

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
        mainBinding.floatBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar make = Snackbar.make(v, "老大，断网了，快叫网管~~", Snackbar.LENGTH_SHORT);
                View view = make.getView();
                view.setBackgroundColor(Color.rgb(0x2a,0xc8,0x7d));
                make.show();
            }
        });
    }




//      Umeng必须做的回调
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }
}
