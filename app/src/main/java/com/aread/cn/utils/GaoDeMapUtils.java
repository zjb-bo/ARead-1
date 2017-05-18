package com.aread.cn.utils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.aread.cn.base.BaseApplication;
import com.aread.cn.net.Net;

/**
 * Created by Administrator on 2017/5/18.
 */

public class GaoDeMapUtils {
    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;

    public GaoDeMapUtils() {
        mapLoationInit();
    }

    public void mapLoationInit(){
        //初始化定位
        mLocationClient = new AMapLocationClient(BaseApplication.getContext());
        mLocationOption = new AMapLocationClientOption();
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        LogUtils.e("zjb--->location:地址："+aMapLocation.getAddress()+"\n城市："+aMapLocation.getCity());
                        Net.getInstance(BaseApplication.getContext()).getWeatherInfo(aMapLocation.getCity());
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        LogUtils.e("zjb---->location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });

        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。网络和GPS都使用
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。 只用网络
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        //设置定位模式为AMapLocationMode.Device_Sensors，仅设备模式。只用GPS
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);

        //获取最近3s内精度最高的一次定位结果：
        //获取一次定位结果：
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否强制刷新WIFI，默认为true，强制刷新。
        mLocationOption.setWifiActiveScan(false);

    }

    public void startLocation(){
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    public void stopLocation(){
        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
    }

    //销毁定位客户端之后，若要重新开启定位请重新New一个AMapLocationClient对象。
    public void destroyLocaiton(){
        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
    }

}
