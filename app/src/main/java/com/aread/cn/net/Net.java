package com.aread.cn.net;

import android.content.Context;
import android.util.ArrayMap;
import android.util.Log;

import com.aread.cn.base.BaseApplication;
import com.aread.cn.bean.JoinTeamBean;
import com.aread.cn.bean.RxBus;
import com.aread.cn.bean.RxBusWeatherInfoBean;
import com.aread.cn.bean.TokenBean;
import com.aread.cn.bean.Users;
import com.aread.cn.bean.WeatherInfoBean;
import com.aread.cn.utils.Contants;
import com.aread.cn.utils.LogUtils;
import com.aread.cn.utils.SPUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/28.
 */

public class Net {
    private static Net net;
    private Context mContext;
    private Retrofit mRetrofit;
    private NetServerce mNetServerce;

    private Net(Context context){
        this.mContext = context;
        mRetrofitInit();
        mNetServerceInit();
    }
    private void mRetrofitInit(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Value.NET_URL_BASE)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void mNetServerceInit() {
        mNetServerce = mRetrofit.create(NetServerce.class);
    }
    public static Net getInstance(Context context){
        if(net == null){
            net = new Net(context);
        }
        return net;
    }

    public interface NetServerce {
        @GET(Value.URL_GETTOKEN)
        Call<TokenBean> getToken();

        @GET(Value.URL_LOGIN)
        Observable<Users> login(@QueryMap Map<String,String> options);

        @FormUrlEncoded
        @POST(Value.URL_REGISTER)
        Observable<Users> register(@FieldMap Map<String,String> options);

        @GET("joinTeam")
        Call<JoinTeamBean> jionTeam(@QueryMap Map<String,String> options);

        @GET("joinTeam")
        Observable<JoinTeamBean> jionTeamObsever(@QueryMap Map<String,String> options);

        @Headers("Authorization:APPCODE d8c31866282647d8bcdbccd860016d0d")
        @GET(Value.URL_BAIDU_WEATHER)
        Observable<WeatherInfoBean> refreshWeatherInfo(@QueryMap Map<String,String> options);

    }


    /**
     * 刷新token(第一次请求token 或者 token过期刷新)
     */
    public String refreshToken(){
        long aLong = SPUtils.getLong(BaseApplication.getContext(), Contants.SP_TOKEN_TIME,0);
        if(System.currentTimeMillis() - aLong > Value.NET_TOKEN_TIME){
            try {
                Call<TokenBean> call = mNetServerce.getToken();
                TokenBean tokenBean = call.execute().body();
                SPUtils.setString(BaseApplication.getContext(),Contants.SP_TOKEN,tokenBean.getAread_token());
                SPUtils.setLong(BaseApplication.getContext(),Contants.SP_TOKEN_TIME,System.currentTimeMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SPUtils.getString(BaseApplication.getContext(), Contants.SP_TOKEN,"");
    }

    /**
     * 登录功能
     * @param userName
     * @param userPwd
     * @param observer
     */
    public void login(String userName,String userPwd,Observer<Users> observer){
        Map<String,String> map = new HashMap<>();
        map.put(Value.NET_PARAMETER_TOKEN,refreshToken());
        map.put(Value.NET_PARAMETER_USERNAME,userName);
        map.put(Value.NET_PARAMETER_USERPWD,userPwd);
        Observable<Users> usersCall = mNetServerce.login(map);
        usersCall.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(observer);
    }

    /**
     * 手机号码注册功能
     * @param phone
     * @param userPwd
     * @param verCode
     * @param observer
     */
    public void register(String phone,String userPwd,String verCode,Observer<Users> observer){
        Map<String,String> map = new HashMap<>();
        map.put(Value.NET_PARAMETER_TOKEN,refreshToken());
        map.put(Value.NET_PARAMETER_USERNAME,phone);
        map.put(Value.NET_PARAMETER_USERPWD,userPwd);
        map.put(Value.NET_PARAMETER_VERCODE,verCode);
        Observable<Users> register = mNetServerce.register(map);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void jionTeam(){
        Map<String,String> map = new HashMap<>();
        map.put("teamNum","0144");
        map.put("userId","3");
        map.put("lat","30.569751");
        map.put("lng","104.053568");
        Call<JoinTeamBean> joinTeamBeanCall = mNetServerce.jionTeam(map);
        joinTeamBeanCall.enqueue(new Callback<JoinTeamBean>() {
            @Override
            public void onResponse(Call<JoinTeamBean> call, Response<JoinTeamBean> response) {
                Log.e("zjb", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<JoinTeamBean> call, Throwable t) {
                Log.e("zjb", "onFailure: "+t.getMessage());

            }
        });
    }

    public void jionTeamObsever(){
        Map<String,String> map = new HashMap<>();
        map.put("teamNum","0144");
        map.put("userId","3");
        map.put("lat","30.569751");
        map.put("lng","104.053568");
        Observable<JoinTeamBean> joinTeamBeanCall = mNetServerce.jionTeamObsever(map);
        joinTeamBeanCall.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JoinTeamBean>() {
            @Override
            public void onCompleted() {
                Log.e("zjb", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("zjb", "onError: "+e.getMessage());
            }

            @Override
            public void onNext(JoinTeamBean joinTeamBean) {
                Log.e("zjb", "onNext: "+joinTeamBean.toString());
            }
        });
    }

    public void getWeatherInfo(String area){
        Map<String,String> map = new ArrayMap<>();
//        map.put("output","json");
//        map.put("ak",Value.URL_BAIDU_APPKEY);
//        map.put("location",area);
//        map.put("mcode",Value.URL_BAIDU_SHA1);
        map.put("ip", "171.213.60.21");
        map.put("area", area);
        Observable<WeatherInfoBean> weatherInfoBeanObservable = mNetServerce.refreshWeatherInfo(map);
        weatherInfoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherInfoBean>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.e("getWeatherInfo完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getWeatherInfo失败："+e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherInfoBean weatherInfoBean) {
                        LogUtils.e("getWeatherInfo成功："+weatherInfoBean.toString());
                        if(weatherInfoBean == null){
                            LogUtils.e("getWeatherInfo成功：weatherInfoBean==null");
                            return;
                        }
                        RxBus.getInstance().post(new RxBusWeatherInfoBean(weatherInfoBean));
                    }
                });
        logCompletedUrl(map,Value.URL_BAIDU_WEATHER);
    }


    private String logCompletedUrl(Map<String,String> map,String url){
        StringBuffer str = new StringBuffer();
        if(map == null)return str.toString();
        str.append(url);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            str.append(next.getKey()).append("=").append(next.getValue()).append("&");
        }
        LogUtils.e("zjb--->完整的请求URL："+str.toString());
        return str.toString();
    }

}
