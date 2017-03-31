package com.aread.cn.net;

/**
 * Created by Administrator on 2017/3/28.
 */

public class Value {
    //网络请求参数的常量
    public static final long NET_TOKEN_TIME = 1000 * 3600 * 24;//这里是token的有效期，单位是ms，这里是一天
    public static final String NET_PARAMETER_TOKEN = "access_token";
    public static final String NET_PARAMETER_USERNAME = "userName";
    public static final String NET_PARAMETER_USERPWD = "userPwd";
    public static final String NET_PARAMETER_VERCODE = "verCode";//验证码

    //网络请求的URL
    public static final String NET_URL_BASE = "http://www.iwhere.com/kuaibao/ttx/yk/";
    public static final String URL_GETTOKEN = "getToken";
    public static final String URL_LOGIN = "login";
    public static final String URL_REGISTER = "register";
}
