package com.aread.cn.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aread.cn.R;
import com.aread.cn.adapter.MainActivityRecycleViewAdapter;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.bean.PopupWindowIdBean;
import com.aread.cn.bean.RecordTextBean;
import com.aread.cn.bean.RxBus;
import com.aread.cn.bean.RxBusWeatherInfoBean;
import com.aread.cn.bean.UserImagerUrlBean;
import com.aread.cn.bean.WeatherInfoBean;
import com.aread.cn.databinding.ActivityMainBinding;
import com.aread.cn.utils.GaoDeMapUtils;
import com.aread.cn.utils.LogUtils;
import com.aread.cn.utils.StringUtils;
import com.aread.cn.view.CustomPopupWindow;
import com.aread.cn.view.WheatherDetialDialog;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding mainBinding;
    private GaoDeMapUtils gaoDeMapUtils;
    private CustomPopupWindow customPopupWindow;
    private Subscription subscribePopupWindowId;
    private Subscription subscribeWeatherInfoBean;
    private WeatherInfoBean weatherInfoBean;
    private WheatherDetialDialog wheatherDetialDialog;
    private MainActivityRecycleViewAdapter adapter;
    private List<RecordTextBean> listDatas;
    private ImageView userImg;
    private TextView userNackName,userSign;

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mainBinding = (ActivityMainBinding) viewDataBinding;
        initToolBar();
        initFloatBtn();
        initRxBus();
//        refreshWeatherInfo();
        initRecyclerView();
    }

    private void initRecyclerView() {
        listDatas = new ArrayList<>();
        listDatas.add(new RecordTextBean());
        listDatas.add(new RecordTextBean());
        adapter = new MainActivityRecycleViewAdapter(this);
        mainBinding.recycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mainBinding.recycleView.setAdapter(adapter);
        adapter.addDatas(listDatas);
    }

    private void initRxBus() {
        subscribePopupWindowId = RxBus.getInstance().toObserverable(PopupWindowIdBean.class)
                .subscribe(new Action1<PopupWindowIdBean>() {
                    @Override
                    public void call(PopupWindowIdBean popupWindowIdBean) {
                        LogUtils.e("zjb---->initRxBus：点击了id:"+popupWindowIdBean.getViewId());
                        startActivity(new Intent(MainActivity.this,RecordTextAcivity.class));
                    }
                });
        subscribeWeatherInfoBean = RxBus.getInstance().toObserverable(RxBusWeatherInfoBean.class)
                .subscribe(new Action1<RxBusWeatherInfoBean>() {
                    @Override
                    public void call(RxBusWeatherInfoBean rxBusWeatherInfoBean) {
                        //获取到weatherInfo
                        weatherInfoBean = rxBusWeatherInfoBean.getWeatherInfoBean();
                    }
                });
        RxBus.getInstance().toObserverable(UserImagerUrlBean.class).subscribe(new Action1<UserImagerUrlBean>() {
            @Override
            public void call(UserImagerUrlBean userImagerUrlBean) {
                userImg.setImageURI(Uri.fromFile(userImagerUrlBean.getImageFile()));
            }
        });
    }

    private void initFloatBtn() {
        FloatingActionButton floatBtn = mainBinding.floatBtn;
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.e("zjb--->MainActivity:floatBtn被点击了");
                showPopupWindow(v);
            }
        });
    }

    private void initToolBar() {

        Toolbar toolbar = mainBinding.myTitle.toolbar;
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        //设置侧滑菜单
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置菜单按钮启用
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, mainBinding.drawerViewLayout, toolbar, R.string.draver_open, R.string.draver_close);
        actionBarDrawerToggle.syncState();
        mainBinding.drawerViewLayout.addDrawerListener(actionBarDrawerToggle);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                mainBinding.drawerViewLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.btn_weather:
                        refreshWeatherInfo();
                        LogUtils.e("zjb--->onMenuItemClick:点击了导航栏天气");
                        break;
                    case R.id.action_compose:
                        LogUtils.e("zjb--->onMenuItemClick:点击了导航栏编辑");
                        break;
                    case R.id.action_delete:
                        LogUtils.e("zjb--->onMenuItemClick:点击了导航栏删除");
                        break;
                    case R.id.action_settings:
                        LogUtils.e("zjb--->onMenuItemClick:点击了导航栏设置");
                        break;

                }
                return true;
            }
        });
        mainBinding.drawerView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                LogUtils.e("zjb--->MenuItem:item.getItemId():"+item.getItemId());
                LogUtils.e("zjb--->MenuItem:item.gettitle():"+item.getTitle());
                item.setChecked(true);
                return true;
            }
        });
        View headerView = mainBinding.drawerView.getHeaderView(0);
        userImg = (ImageView) headerView.findViewById(R.id.user_img);
        userNackName = (TextView) headerView.findViewById(R.id.user_nackName);
        userSign = (TextView) headerView.findViewById(R.id.user_sign);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TakePhotoActivity.class));
            }
        });
    }

    private void showPopupWindow(View parent) {
        if (customPopupWindow == null) {
            customPopupWindow = new CustomPopupWindow(this);
        }
        customPopupWindow.showPopupWindow(parent);
    }

    private void refreshWeatherInfo() {
        if(weatherInfoBean != null){
            showWeatherDialog();
        }
        if(!StringUtils.noOperateInMs(5*60*1000)){//需要间隔5分钟以上才能获取一次天气
            LogUtils.e("zjb---->不好意思，获取天气太频繁！");
            return;
        }
        if(gaoDeMapUtils == null){
            gaoDeMapUtils = new GaoDeMapUtils();
        }
        gaoDeMapUtils.startLocation();
    }

    private void showWeatherDialog(){
        if(wheatherDetialDialog == null){
            wheatherDetialDialog = new WheatherDetialDialog(this);
        }
        wheatherDetialDialog.initData(weatherInfoBean);
        wheatherDetialDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        if(subscribePopupWindowId != null && !subscribePopupWindowId.isUnsubscribed()){
            subscribePopupWindowId.unsubscribe();
        }
        if(subscribeWeatherInfoBean != null && !subscribeWeatherInfoBean.isUnsubscribed()){
            subscribeWeatherInfoBean.unsubscribe();
        }
        if(gaoDeMapUtils != null){
            gaoDeMapUtils.destroyLocaiton();
        }
        super.onDestroy();
    }

    //      Umeng分享必须做的回调
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }
}
