package com.aread.cn.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivitySplashBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SplashActivity extends BaseActivity {
    private ActivitySplashBinding splashBinding;
    @Override
    protected int setView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        splashBinding = (ActivitySplashBinding) viewDataBinding;

        initViewPager();
        initToolBar();

    }
    private void initToolBar() {
        Toolbar toolbar = splashBinding.commonTitle.toolbar;
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        //设置侧滑菜单
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置菜单按钮启用
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, splashBinding.drawerViewLayout, toolbar, R.string.draver_open, R.string.draver_close);
        actionBarDrawerToggle.syncState();
        splashBinding.drawerViewLayout.addDrawerListener(actionBarDrawerToggle);
    }

    private void initViewPager() {
        final List<ImageView> list = new ArrayList<>();
        int[] idArray = new int[]{R.mipmap.first,R.mipmap.seccond,R.mipmap.third,R.mipmap.guid,R.mipmap.login};
        for (int i = 0; i < idArray.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(idArray[i]);
            list.add(imageView);
        }
        splashBinding.viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ImageView imageView = list.get(position);
                container.removeView(imageView);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = list.get(position);
                container.addView(imageView);
                return imageView;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
