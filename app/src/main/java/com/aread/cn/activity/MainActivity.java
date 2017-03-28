package com.aread.cn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aread.cn.R;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initRetrofit();
    }

    private void initRetrofit() {

    }

    private void init() {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                subscriber.onNext("This is my first Rxjava");
                subscriber.onCompleted();//nsif
            }
        }).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                Log.e("zjb", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("zjb", "onError: "+e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                Log.e("zjb", "onNext: "+o.toString());
            }
        });
    }
}
