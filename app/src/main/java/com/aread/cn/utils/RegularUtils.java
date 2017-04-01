package com.aread.cn.utils;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/4/1.
 */

public class RegularUtils {

    public static boolean checkPhone(String phone){
        if(TextUtils.isEmpty(phone)){
            phone = "";
        }
        return phone.matches("^^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$");
    }
}
