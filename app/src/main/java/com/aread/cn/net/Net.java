package com.aread.cn.net;

import android.content.Context;

import com.aread.cn.application.BaseApplication;
import com.aread.cn.bean.TokenBean;
import com.aread.cn.bean.Users;
import com.aread.cn.utils.Contants;
import com.aread.cn.utils.SPUtils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;

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
                .baseUrl("")
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
        @GET("book/getToken")
        Call<TokenBean> getToken();

        @GET("book/login")
        Observable<Users> login(@Query("userName") String userName, @Query("userPwd") String userPwd);

        @GET("book/register")
        Observable<Users> register(@Query("userName") String userName,@Query("userPwd") String userPwd,@Query("verCode") String verCode);
    }


    /**
     * 刷新token(第一次请求token 或者 token过期刷新)
     */
    public void refreshToken(){
        long aLong = SPUtils.getLong(BaseApplication.getContext(), Contants.SP_TOKEN_TIME,0);
        if(System.currentTimeMillis() - aLong < Value.VALUE_TOKEN_TIME){
            return;
        }
        try {
            Call<TokenBean> call = mNetServerce.getToken();
            TokenBean tokenBean = call.execute().body();
            SPUtils.setString(BaseApplication.getContext(),Contants.SP_TOKEN,tokenBean.getAread_token());
            SPUtils.setLong(BaseApplication.getContext(),Contants.SP_TOKEN_TIME,System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 登录功能
     * @param userName
     * @param userPwd
     * @param observer
     */
    public void login(String userName,String userPwd,Observer<Users> observer){
        refreshToken();
        Observable<Users> usersCall = mNetServerce.login(userName, userPwd);
//        usersCall.enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//
//            }
//        });
        usersCall.subscribe(observer);
    }

    /**
     * 手机号码注册功能
     * @param phone
     * @param userPwd
     * @param verCode
     * @param observer
     */
    public void register(String phone,String userPwd,String verCode,Observer<Users> observer){
        refreshToken();
        Observable<Users> register = mNetServerce.register(phone, userPwd, verCode);
        register.subscribe(observer);
    }


}
