package com.aread.cn.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityLoginBinding;

/**
 * Created by Administrator on 2017/3/31.
 */

public class LoginAcitity extends BaseActivity implements View.OnClickListener {
    private ActivityLoginBinding  activityLoginBinding;

    @Override
    protected int setView() {
        return R.layout.activity_login;
    }
    @Override
    protected void initData() {
        activityLoginBinding = (ActivityLoginBinding) viewDataBinding;
        activityLoginBinding.editPhone.addTextChangedListener(editListener);
        activityLoginBinding.loginGo.setOnClickListener(this);
    }
    private TextWatcher editListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() >= 11){
                activityLoginBinding.editPhone.clearFocus();
                activityLoginBinding.loginGo.setVisibility(View.VISIBLE);

            }else {
                activityLoginBinding.loginGo.setVisibility(View.GONE);
            }
        }
    };

    @Override
    public void onClick(View v) {
        //请求登陆接口
        Toast.makeText(this,"请求登陆", Toast.LENGTH_SHORT).show();
//        Net.getInstance(this).login(activityLoginBinding.loginGo.getText().toString(), "", new Observer<Users>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Users users) {
//
//            }
//        });
    }
}
