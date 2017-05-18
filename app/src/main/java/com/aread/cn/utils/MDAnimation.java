package com.aread.cn.utils;

import android.animation.Animator;
import android.os.Build;
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

    /**
     * 圆形扩散动画
     * @param view //动画作用view
     * @param duration //动画时间
     * @param x  //扩散起始点x
     * @param y //扩散起始点y
     */
    public static void circularDiffusionAnimation(View view,int duration,int x,int y) {
        //因为CircularReveal动画是api21之后才有的,所以加个判断语句,免得崩溃
        if(view == null )return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cicular_R = view.getHeight() / 2 > view.getWidth() / 2 ? view.getHeight() / 2 : view.getWidth() / 2;
            Animator animator = ViewAnimationUtils.createCircularReveal(view,x, y, 0, cicular_R);
            animator.setDuration(duration);
            animator.start();
        } else {
            LogUtils.e("zjb-->错误：圆形扩散动画无效，原因：版本过低，当前版本："+Build.VERSION.SDK_INT+"，最低有效版本："+Build.VERSION_CODES.LOLLIPOP);
        }

    }
}
