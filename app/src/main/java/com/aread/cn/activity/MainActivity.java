package com.aread.cn.activity;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mainBinding = (ActivityMainBinding) viewDataBinding;
        initToolBar();
//        mainBinding.floatBar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar make = Snackbar.make(v, "老大，断网了，快叫网管~~", Snackbar.LENGTH_SHORT);
//                View view = make.getView();
//                view.setBackgroundColor(Color.rgb(0x2a,0xc8,0x7d));
//                make.show();
//            }
//        });
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
    }


    //      Umeng分享必须做的回调
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
