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
    public static final String URL_BAIDU_WEATHER = "http://ali-weather.showapi.com/area-to-weather?"; //百度天气接口
    public static final String URL_BAIDU_APPKEY = "U92xK4IW3UiikoRG5zC0GF9wuno0Ga0V";//百度APPkey
    public static final String URL_BAIDU_SHA1 = "D9:3F:67:77:5A:26:E9:0D:65:63:86:25:DD:BA:3A:95:E3:13:40:AC";//百度APPkey
}
