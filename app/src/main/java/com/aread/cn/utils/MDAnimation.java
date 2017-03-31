package com.aread.cn.utils;

import android.animation.Animator;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by Administrator on 2017/3/31.
 */

public class MDAnimation {

    /**
     * 溶解进入动画
     * @param view
     * @param ms
     */
    public static void revealInAnimation(View view,int ms){
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2
                , view.getWidth() / 2, 0, view.getWidth());
        circularReveal.setDuration(ms);
        circularReveal.start();
    }

    /**
     * 溶解退出动画
     * @param view
     * @param ms
     */
    public static void revealAnimation(View view,int ms){
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2
                , view.getWidth() / 2, view.getWidth(),0 );
        circularReveal.setDuration(ms);
        circularReveal.start();
    }
}
