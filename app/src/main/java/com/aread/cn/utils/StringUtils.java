package com.aread.cn.utils;

/**
 * Created by bobo on 2017/5/6.
 */

public class StringUtils {

    public static String recorderTimeCount(int count){
        String time = "00:00";
        if(count < 10){
            time = "00:0"+count;
        }else if(count >= 10 && count < 60){
            time = "00:"+count;
        }else if(count >=60 && count < 600){
            time = "0"+count/60+":"+count%60/10+count%60%10;
        }else {
            time = count/60+":"+count%60/10+count%60%10;
        }
        return time;
    }

    /**
     * 多少毫秒内不能进行操作
     * @param ms
     * @return
     */
    private static long currentMs = 0;
    public static boolean noOperateInMs(int ms){
        boolean isOvered = false;
        if(System.currentTimeMillis() - currentMs > ms){
            isOvered = true;
        }else {
            isOvered = false;
        }
        currentMs = System.currentTimeMillis();
        return isOvered;
    }
}
