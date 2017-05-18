package com.aread.cn.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.aread.cn.R;
import com.aread.cn.bean.PopupWindowIdBean;
import com.aread.cn.bean.RxBus;
import com.aread.cn.utils.LogUtils;


/**
 * Created by Administrator on 2017/5/18.
 */

public class CustomPopupWindow extends PopupWindow implements View.OnClickListener {
    private View mContentView;
    private Context context;

    public CustomPopupWindow(Context context) {
        this(context,null);
    }
    public CustomPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public CustomPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContentView = inflater.inflate(R.layout.item_funciton_popwind, new RelativeLayout(context),true);
        mContentView.findViewById(R.id.send_img).setOnClickListener(this);
        mContentView.findViewById(R.id.send_recorder).setOnClickListener(this);
        mContentView.findViewById(R.id.send_text).setOnClickListener(this);
        mContentView.findViewById(R.id.send_video).setOnClickListener(this);
        // 设置SelectPicPopupWindow的View
        this.setContentView(mContentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // 设置SelectPicPopupWindow弹出窗体动画效果
//        this.setEnterTransition(new ChangeImageTransform());
    }

    public void showPopupWindow(View view){
        if(!this.isShowing()){
            showAtLocation(view, Gravity.CENTER,0,0);
        }
    }

    public void closePopupWindow(){
        if(this.isShowing()){
            this.dismiss();
        }
    }


    @Override
    public void onClick(View v) {
        LogUtils.e("zjb---->CustomPopupWindow：点击了id:"+v.getId());
        closePopupWindow();
        RxBus.getInstance().post(new PopupWindowIdBean(v.getId()));
    }
}
