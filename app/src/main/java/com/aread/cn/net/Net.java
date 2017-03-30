package com.aread.cn.net;

import android.content.Context;
import android.util.Log;

import com.aread.cn.base.BaseApplication;
import com.aread.cn.bean.JoinTeamBean;
import com.aread.cn.bean.TokenBean;
import com.aread.cn.bean.Users;
import com.aread.cn.utils.Contants;
import com.aread.cn.utils.SPUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
        @GET("getToken")
        Call<TokenBean> getToken();

        @GET("login")
        Observable<Users> login(@QueryMap Map<String,String> options);

        @FormUrlEncoded
        @POST("register")
        Observable<Users> register(@FieldMap Map<String,String> options);

        @GET("joinTeam")
        Call<JoinTeamBean> jionTeam(@QueryMap Map<String,String> options);

        @GET("joinTeam")
        Observable<JoinTeamBean> jionTeamObsever(@QueryMap Map<String,String> options);

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

}
