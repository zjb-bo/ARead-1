package com.aread.cn.view;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.aread.cn.utils.LogUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2017/5/25.
 */

public class CanmeraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Camera mCamera;

    public CanmeraSurfaceView(Camera camera,Context context) {
        this(context,null);
        this.mCamera = camera;
    }

    public CanmeraSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanmeraSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(holder.getSurface() == null){
            return;
        }

        try {
            mCamera.stopPreview();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            mCamera.setPreviewDisplay(holder);
//            mCamera.startPreview();

            //针对相机预览产生变形的处理
            Camera.Parameters parameters = mCamera.getParameters();// 获得相机参数
            Camera.Size s = parameters.getPreviewSize();
            double w = s.width;
            double h = s.height;

            LogUtils.e("zjb--->getPreviewSize:s.width："+w+" s.height:"+h);
            LogUtils.e("zjb--->getPreviewSize:surfacewidth："+width+" surfaceheight:"+height);

            if( width>height )
            {
                this.setLayoutParams(new FrameLayout.LayoutParams(width, (int) (width*h/w)) );
            }
            else
            {
                this.setLayoutParams(new FrameLayout.LayoutParams((int) (height*h/w), height));
            }
//            parameters.setPreviewSize(width, height); // 设置预览图像大小
//            parameters.setPictureFormat(PixelFormat.JPEG); // 设置照片格式
//            mCamera.setParameters(parameters);// 设置相机参数

            mCamera.startPreview();// 开始预览
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
