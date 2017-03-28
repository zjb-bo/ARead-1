package com.aread.cn.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/11.
 */
public class SPUtils {
    private final static String FILE_NAME = "SP_FILE_NAME";
    public  static void save(Context context, String key, String value){
        //实例化SharedPreferences对象（第一步）
        SharedPreferences mySharedPreferences= context.getSharedPreferences(FILE_NAME,
                Activity.MODE_PRIVATE);
        //实例化SharedPreferences.Editor对象（第二步）
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        //用putString的方法保存数据
        editor.putString(key, value);
        //提交当前数据
        editor.commit();
    }

    public static String getString(Context context, String key, String defaultvalue){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        return sp.getString(key,defaultvalue);
    }

    public static void setString(Context context, String key, String value){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,value);
        edit.commit();
    }
    public static long getLong(Context context, String key, long defaultvalue){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        return sp.getLong(key,defaultvalue);
    }

    public static void setLong(Context context, String key, long value){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putLong(key,value);
        edit.commit();
    }


    public  static void save(Context context, String key, boolean value){
        //实例化SharedPreferences对象（第一步）
        SharedPreferences mySharedPreferences= context.getSharedPreferences(FILE_NAME,
                Activity.MODE_PRIVATE);
        //实例化SharedPreferences.Editor对象（第二步）
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        //用putString的方法保存数据
        editor.putBoolean(key, value);
        //提交当前数据
        editor.commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultvalue){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        return sp.getBoolean(key,defaultvalue);
    }

    public static void clear(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        edit.commit();
    }
}
