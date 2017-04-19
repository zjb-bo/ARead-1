package com.aread.cn.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityLoginBinding;
import com.aread.cn.utils.RegularUtils;
import com.aread.cn.utils.ShowMsgUitls;
import com.aread.cn.utils.UmengLoginShareUtils;
import com.umeng.socialize.bean.SHARE_MEDIA;

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
        activityLoginBinding.guangguang.setOnClickListener(this);
        activityLoginBinding.loginQq.setOnClickListener(this);
        activityLoginBinding.loginWeibo.setOnClickListener(this);
        activityLoginBinding.loginWeixin.setOnClickListener(this);
    }
    private TextWatcher editListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() >= 11){
                if(RegularUtils.checkPhone(s.toString())){
                    activityLoginBinding.loginGo.setVisibility(View.VISIBLE);
                }else {
                    ShowMsgUitls.showCenterToast(getString(R.string.errorPhone),Toast.LENGTH_SHORT);
                }

            }else {
                activityLoginBinding.loginGo.setVisibility(View.GONE);
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_go:
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(activityLoginBinding.editPhone.getWindowToken(), 0); //强制隐藏键盘
                //请求登陆接口
                ShowMsgUitls.showCenterToast(getString(R.string.netRun),Toast.LENGTH_SHORT);
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
                break;
            case R.id.guangguang:
                startActivity(new Intent(LoginAcitity.this,MainActivity.class));
                break;
            case R.id.login_qq:
                UmengLoginShareUtils.getInstance(LoginAcitity.this).thirdLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.login_weibo:
                UmengLoginShareUtils.getInstance(LoginAcitity.this).thirdLogin(SHARE_MEDIA.SINA);
                break;
            case R.id.login_weixin:
                UmengLoginShareUtils.getInstance(LoginAcitity.this).thirdLogin(SHARE_MEDIA.WEIXIN);
                break;
        }
    }

    private void dealVerCode(){
        activityLoginBinding.editPhone.setHint(getString(R.string.inputVerCode));
        activityLoginBinding.editPhone.getText().clear();

    }

}
