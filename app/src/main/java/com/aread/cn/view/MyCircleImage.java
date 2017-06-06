package com.aread.cn.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/6/5.
 */

public class MyCircleImage extends ImageView {
    private Paint paint;


    public MyCircleImage(Context context) {
        this(context, null);
    }

    public MyCircleImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }

    Rect src;
    Rect dst;

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if(bitmap == null){
            super.onDraw(canvas);
        }else {

            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            int i = measuredHeight / 2;
            int border = borderWidth / 2;
            paint.reset();
            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            canvas.drawCircle(i,i,i,paint);

            int width = Math.min(measuredHeight,measuredWidth);
            Bitmap cropImageBitmap = getCropImage(bitmap, width);
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if(src == null || dst == null){
                src = new Rect();
                dst = new Rect();
            }
            src.set(0,0,min,min);
            dst.set(0,0,measuredWidth-borderWidth,measuredHeight-borderWidth);
            paint.reset();
            canvas.translate(border,border);//由于是从左上开始画UI所以，平移画布保证图片在中间
            canvas.drawBitmap(cropImageBitmap,src,dst,paint);
        }


    }

    private int borderWidth= 10;
    private Bitmap getCropImage(Bitmap bitmap,int width){
        Bitmap bitmap1 = null;
//        width -= borderWidth;
//        //1-判断bitmap的尺寸是否和Imageview的尺寸相同
//        if(bitmap.getHeight() != width || bitmap.getWidth() != width){
//            bitmap1 = Bitmap.createScaledBitmap(bitmap,width,width,true); //将bitmap缩放和Imageview尺寸相同，true表示平滑缩放
//        }else {
//            bitmap1 = bitmap;
//        }
//        int r = width / 2;//半径

        int height = bitmap.getHeight();
        int width1 = bitmap.getWidth();
        bitmap1 = bitmap;
        int r = height>width1?width1/2:height/2;
        int min = r*2;
        //2-创建一个bitmap背景，new一个canvas
        Bitmap reslutBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(reslutBitmap);
        Rect rect = new Rect(0, 0, min, min);

        canvas.drawCircle(r,r,r,paint);//画圆
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//相交
        canvas.drawBitmap(bitmap1,rect,rect,paint);//画图

//        bitmap1.recycle();
        return reslutBitmap;
    }
}
