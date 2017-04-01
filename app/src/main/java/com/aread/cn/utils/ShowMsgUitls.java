package com.aread.cn.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.aread.cn.base.BaseApplication;

/**
 * Created by Administrator on 2017/4/1.
 */

public class ShowMsgUitls {

    /**
     * 在底部弹出Toast显示
     * @param msg 内容
     * @param shortOrLong 显示时长；1-Toast.LENGTH_LONG   2-Toast.LENGTH_SHORT
     */
    public static void showBottomToast(String msg,int shortOrLong){
        Toast.makeText(BaseApplication.getContext(),msg,shortOrLong).show();
    }

    /**
     * 在中间弹出Toast显示
     * @param msg
     * @param shortOrLong
     */
    public static void showCenterToast(String msg,int shortOrLong){
        Toast toast = Toast.makeText(BaseApplication.getContext(), msg, shortOrLong);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    /**
     * 在顶部弹出Toast显示
     * @param msg
     * @param shortOrLong
     */
    public static void showTopToast(String msg,int shortOrLong){
        Toast toast = Toast.makeText(BaseApplication.getContext(), msg, shortOrLong);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
    }

}
