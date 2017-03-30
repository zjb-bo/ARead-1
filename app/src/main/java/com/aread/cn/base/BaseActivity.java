package com.aread.cn.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by bobo on 2017/3/29.
 */

public abstract class BaseActivity extends AppCompatActivity{
    public ViewDataBinding viewDataBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewBefore();
        if(setView() != 0){
            viewDataBinding = DataBindingUtil.setContentView(this, setView());
        }
        initData();
        //push each activity to ActivityManger when created
        ActivityManager.getInstance().pushActivity(this);

    }

    /**
     * all activities who extends BasteActiviyt is  no title
     * if you want,could overrived this method in child activity
     * and delete super.setViewBefore();
     */
    protected void setViewBefore(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
    }
    protected abstract int setView();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //pop each activity to ActivityManger when Destoryed
        ActivityManager.getInstance().popActivity(this);
    }
}
