package com.aread.cn.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/3/28.
 */

public class BaseApplication extends Application {
    private static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static BaseApplication getContext(){
        return app;
    }
}
