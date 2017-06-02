package com.aread.cn.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aread.cn.R;
import com.aread.cn.base.BaseActivity;
import com.aread.cn.databinding.ActivityTakephotoBinding;
import com.aread.cn.listener.MyGestureListener;
import com.aread.cn.utils.LogUtils;
import com.aread.cn.utils.ShowMsgUitls;
import com.aread.cn.view.CanmeraSurfaceView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */

public class TakePhotoActivity extends BaseActivity {
    ActivityTakephotoBinding databinding = (ActivityTakephotoBinding) viewDataBinding;
    private Camera mCamera;
    private int mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
    private FrameLayout frameLayout;
    private LinearLayout ll;
    private int flashLed = 0;
    private DisplayMetrics dm;
    private ImageView imageView;
    private View view,photoView,bgView;
    private GestureDetector gestureDetector;


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


    private float startX,startY;
    private Matrix matrix = new Matrix();
    private void initView() {

        gestureDetector = new GestureDetector(this,new MyGestureListener());
        //屏幕尺寸
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        LogUtils.e("屏幕分辨率w:"+dm.widthPixels+" h:"+dm.heightPixels);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        ll = (LinearLayout) findViewById(R.id.flashLed_ll);
        imageView = (ImageView) findViewById(R.id.image_crop);
        view = (View) findViewById(R.id.image_view);
        bgView = (View) findViewById(R.id.bg);
        photoView = (View) findViewById(R.id.photoview);
        view.setVisibility(View.INVISIBLE);
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
                ShowMsgUitls.showCenterToast("点击了闪光灯",Toast.LENGTH_SHORT);
                int minWidth = ll.getWidth() * -1;
                int maxWidth = ll.getWidth();
                if(flashLed == 0){
                    startValue(ll,"X",minWidth,0);
                    flashLed = 1;
                }else {
                    startValue(ll,"X",0,minWidth);
                    flashLed = 0;
                }
            }
        });


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                   return gestureDetector.onTouchEvent(event);
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(event.getPointerCount() == 1){
                            startX = event.getRawX();
                            startY = event.getRawY();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float rawX = event.getRawX();
                        float rawY = event.getRawY();

                        float vX = rawX - startX;
                        float vY = rawY - startY;
                        int height = bgView.getHeight();


                        if(vY == 0)return true;

                        LogUtils.e("zjb---->vY:"+vY+" height:"+height+" rawX："+rawX+" rawY:"+rawY);
                        if(vY > height){
                            vY = height;
                        }else if(vY < -height){
                            vY = -height;

                        }
                        matrix.setTranslate(0,vY);
                        imageView.setImageMatrix(matrix);

                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                        Bitmap bitmap = drawable.getBitmap();
                        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, (int) Math.abs((event.getRawX() - startX)), bitmap.getWidth(), dm.heightPixels - 2 * bgView.getHeight());
                        savePic(bitmap1);
                        bitmap.recycle();
                        break;


                }

                return true;
            }
        });

    }



    private double x,y;

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
//            Camera.Parameters parameters = mCamera.getParameters();
//            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
//            Camera.Size closelyPreSize = getCloselyPreSize(true, dm.widthPixels, dm.heightPixels, supportedPreviewSizes);
//            parameters.setPreviewSize(closelyPreSize.width,closelyPreSize.height);
//            mCamera.setParameters(parameters);
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
            // 获取当前旋转角度, 并旋转图片
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            if (mCameraId == Camera.CameraInfo.CAMERA_FACING_BACK) {
                bitmap = rotateBitmapByDegree(bitmap, 90);
            } else {
                bitmap = rotateBitmapByDegree(bitmap, -90);
            }


            float v = dm.heightPixels * 1.0f / bitmap.getHeight();
            Matrix matrix1 = new Matrix();
            matrix1.setScale(v,v);
            Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, dm.widthPixels, dm.heightPixels, matrix1, false);
            bitmap.recycle();

            view.setVisibility(View.VISIBLE);
            photoView.setVisibility(View.INVISIBLE);
            imageView.setImageBitmap(bitmap1);
            LogUtils.e("zjb--->bitmap"+bitmap1.getWidth()+" "+bitmap1.getHeight());
            //拍照完后，继续预览
            mCamera.startPreview();


//            bitmap.recycle();

        }
    };



    private void savePic(final Bitmap bitmap){
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
    }

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
        final ValueAnimator anim = ValueAnimator.ofFloat(from,to);
        anim.setTarget(view);
        anim.setDuration(200);
        anim.start();
        view.setVisibility(View.VISIBLE);
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

    //拍照闪光灯
//    1、自动闪光（Auto）
//    2、强制闪光（Forced），
//    3、消除红眼（Red-Eye）
//    4、慢速闪光同步（Slow）
//    5、强制关闭闪光（Off）
    public void setFlashLed(String Value){
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setFlashMode(Value);
            mCamera.setParameters(parameters);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * SurfaceView尺寸和PreSize预览尺寸不匹配导致变形，找到最接近的尺寸进行配置
     * @param isPortrait  是否竖屏
     * @param surfaceWidth
     * @param surfaceHeight
     * @param preSize
     * @return
     */
    public Camera.Size getCloselyPreSize(boolean isPortrait,int surfaceWidth, int surfaceHeight, List<Camera.Size> preSize){
        int currentWidth,currentHeight;
        //如果是竖屏的 则交换宽高
        if(isPortrait){
            currentWidth = surfaceHeight;
            currentHeight = surfaceWidth;
        }else {
            currentHeight = surfaceHeight;
            currentWidth = surfaceWidth;
        }

        for (Camera.Size size: preSize) {
            if(currentWidth == size.width && currentHeight == size.height){
                return size;
            }
        }

        // 得到与传入的宽高比最接近的size
        float reqRatio = ((float) currentWidth) / currentHeight;
        float curRatio, deltaRatio;
        float deltaRatioMin = Float.MAX_VALUE;
        Camera.Size retSize = null;
        for (Camera.Size size : preSize) {
            curRatio = ((float) size.width) / size.height;
            deltaRatio = Math.abs(reqRatio - curRatio);
            if (deltaRatio < deltaRatioMin) {
                deltaRatioMin = deltaRatio;
                retSize = size;
            }
        }
        return retSize;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        photoView.setVisibility(View.VISIBLE);
        view.setVisibility(View.INVISIBLE);
    }
}
