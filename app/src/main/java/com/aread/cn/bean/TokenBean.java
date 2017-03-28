package com.aread.cn.bean;

/**
 * Created by bobo on 2017/3/28.
 */
public class TokenBean {
    public String aread_token;
    public long time_Ms;

    public TokenBean(String aread_token, long time_Ms) {
        this.aread_token = aread_token;
        this.time_Ms = time_Ms;
    }

    public TokenBean() {
    }

    public String getAread_token() {
        return aread_token;
    }

    public void setAread_token(String aread_token) {
        this.aread_token = aread_token;
    }

    public long getTime_Ms() {
        return time_Ms;
    }

    public void setTime_Ms(long time_Ms) {
        this.time_Ms = time_Ms;
    }
}
