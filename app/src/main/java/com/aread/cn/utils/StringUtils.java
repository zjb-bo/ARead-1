package com.aread.cn.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static String getWheatherTimeStampDay()
    {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日  ");
        String end_time = df.format(System.currentTimeMillis());
        return end_time;
    }

    public static String getXingqi()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day){
            case Calendar.MONDAY:return "星期一";
            case Calendar.TUESDAY:return "星期二";
            case Calendar.WEDNESDAY:return "星期三";
            case Calendar.THURSDAY:return "星期四";
            case Calendar.FRIDAY:return "星期五";
            case Calendar.SATURDAY:return "星期六";
            case Calendar.SUNDAY:return "星期日";
        }
        return "星期日";
    }
}
