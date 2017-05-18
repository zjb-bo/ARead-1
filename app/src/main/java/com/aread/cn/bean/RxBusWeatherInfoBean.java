package com.aread.cn.bean;

/**
 * Created by Administrator on 2017/5/18.
 */
public class RxBusWeatherInfoBean {

    public WeatherInfoBean getWeatherInfoBean() {
        return weatherInfoBean;
    }

    public void setWeatherInfoBean(WeatherInfoBean weatherInfoBean) {
        this.weatherInfoBean = weatherInfoBean;
    }

    private WeatherInfoBean weatherInfoBean;

    public RxBusWeatherInfoBean(WeatherInfoBean weatherInfoBean) {
        this.weatherInfoBean = weatherInfoBean;
    }
}
