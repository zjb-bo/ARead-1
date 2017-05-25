package com.aread.cn.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.Surface;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityTakephotoBinding;
import com.aread.cn.utils.LogUtils;
import com.aread.cn.utils.ShowMsgUitls;
import com.aread.cn.view.CanmeraSurfaceView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/25.
 */

public class TakePhotoActivity extends BaseActivity {
    ActivityTakephotoBinding databinding = (ActivityTakephotoBinding) viewDataBinding;
    private Camera mCamera;
    private int mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
    private FrameLayout frameLayout;
    private LinearLayout ll;


    @Override
    protected int setView() {
        return R.layout.activity_takephoto;
    }

    @Override
    protected void initData() {
        initView();
        if(!checkCameraHardware(this)){
            ShowMsgUitls.showCenterToast("不支持相机", Toast.LENGTH_SHORT);
        }else {
            openCamera();
        }

        //设置相机的方向，随屏幕方向
        setCameraDisplayOrientation(this,mCameraId,mCamera);
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        ll = (LinearLayout) findViewById(R.id.flashLed_ll);
        findViewById(R.id.takePhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCamera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera camera) {
                        ShowMsgUitls.showCenterToast("正在聚焦",Toast.LENGTH_SHORT);

                        if(success){
                            ShowMsgUitls.showCenterToast("聚焦成功",Toast.LENGTH_SHORT);
                        }else {
                            ShowMsgUitls.showCenterToast("聚焦失败",Toast.LENGTH_SHORT);
                        }
                        mCamera.takePicture(null,null,mPictureCallback);
                    }
                });
            }
        });
        findViewById(R.id.switchCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchCamera();
            }
        });
        findViewById(R.id.flashLed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switchCamera();
                startValue(ll,"X",0,1);
            }
        });
    }

    // 判断相机是否支持
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    // 获取相机
    public Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(mCameraId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    // 释放相机
    public void releaseCamera() {
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    // 拍照回调
    private Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(final byte[] data, Camera camera) {
            File pictureDir = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (pictureDir == null) {
                LogUtils.e("没有读写权限");
                return;
            }
            final String picturePath = pictureDir
                    + File.separator
                    + new DateFormat().format("yyyyMMddHHmmss", new Date())
                    .toString() + ".jpg";

            new Thread(new Runnable() {
                @Override
                public void run() {
                    File file = new File(picturePath);
                    try {
                        // 获取当前旋转角度, 并旋转图片
                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        if (mCameraId == Camera.CameraInfo.CAMERA_FACING_BACK) {
                            bitmap = rotateBitmapByDegree(bitmap, 90);
                        } else {
                            bitmap = rotateBitmapByDegree(bitmap, -90);
                        }
                        BufferedOutputStream bos = new BufferedOutputStream(
                                new FileOutputStream(file));
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                        bos.flush();
                        bos.close();
                        bitmap.recycle();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            //拍照完后，继续预览
            mCamera.startPreview();
        }
    };

    // 设置相机横竖屏
    public static void setCameraDisplayOrientation(Activity activity,int cameraId, Camera camera) {

        android.hardware.Camera.CameraInfo info = new android.hardware.Camera.CameraInfo();
        android.hardware.Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {//前置摄像头
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;
        } else {// 后置摄像头
            result = (info.orientation - degrees + 360) % 360;
        }
        camera.setDisplayOrientation(result);
    }

    // 旋转图片
    public static Bitmap rotateBitmapByDegree(Bitmap bm, int degree) {
        Bitmap returnBm = null;
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        try {
            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(),
                    bm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
        }
        if (returnBm == null) {
            returnBm = bm;
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }

    // 切换前置和后置摄像头
    public void switchCamera() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(mCameraId, cameraInfo);
        if(cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK){
            mCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;
        }
        else{
            mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
        }
        frameLayout.removeView(canmeraSurfaceView);
        releaseCamera();
        openCamera();
        setCameraDisplayOrientation(this, mCameraId, mCamera);
    }

    private CanmeraSurfaceView canmeraSurfaceView;
    private void openCamera() {
        mCamera = getCameraInstance();
        canmeraSurfaceView = new CanmeraSurfaceView(mCamera, this);
        canmeraSurfaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCamera.autoFocus(null);
            }
        });
        frameLayout.addView(canmeraSurfaceView);
    }

    /**
     * 设置view的平移动画，可设置X或Y方向的平移
     * @param view  要平移的view
     */
    public static void startValue(final View view,final String orientation,float from,float to){
        ValueAnimator anim = ValueAnimator.ofFloat(from,to);
        anim.setTarget(view);
        anim.setDuration(2000);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (orientation.equals("y")) {
                    view.setTranslationY((Float)animation.getAnimatedValue());
                }else{
                    view.setTranslationX((Float)animation.getAnimatedValue());
                }
            }
        });
    }
}
