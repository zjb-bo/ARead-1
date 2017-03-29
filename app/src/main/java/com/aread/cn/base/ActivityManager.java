package com.aread.cn.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/29.
 * Custom ActivityManager to management all activities
 */

public class ActivityManager {
    private static ActivityManager activityManager;
    private Stack<Activity> activityStack;
    private ActivityManager(){
        activityStack = new Stack<>();
    }
    public static ActivityManager getInstance(){
        if(activityManager == null){
            activityManager = new ActivityManager();
        }
        return activityManager;
    }


    public void popActivity(Activity activity){
       synchronized (activityStack){
           if(activity != null){
               activityStack.remove(activity);
           }
       }
    }

    public void pushActivity(Activity activity){
        synchronized (activityStack){
            if(activity != null){
                activityStack.add(activity);
            }
        }
    }
    
    public void finshAllActivity(){
        synchronized (activityStack){
            for (int i = 0; i < activityStack.size(); i++) {
                activityStack.remove(i).finish();
            }
            activityStack.clear();
        }
    }

    public void setActivityStackClear(){
        synchronized (activityStack){
            activityStack.clear();
        }
    }

    public Activity getTopActivity(){
        synchronized (activityStack){
            Activity activity = activityStack.lastElement();
            return activity;
        }
    }

    /**
     * @param activityName //eg:MainActivity.class.getName()
     */
    public void toActivity(String activityName){
        synchronized (activityStack){
            Activity mainActivity = null;
            for (Activity activity: activityStack) {
                if(activity.getClass().getName().equals(activityName)){
                    mainActivity = activity;
                    setActivityStackClear();
                    pushActivity(mainActivity);
                }else {
                    activity.finish();
                }
            }
        }
    }


}
