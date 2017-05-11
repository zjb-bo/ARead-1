package com.aread.cn.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/5/8.
 */

public class MusicImageView extends ImageView{
    private Paint paint;
    private Matrix matrix;
    private boolean isSrcRatote = false;

    private float allProgress = 100;

    private float currentProgress = 0;

    public MusicImageView(Context context) {
        super(context);
        init();
    }

    public MusicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MusicImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        matrix = new Matrix();
    }

    /**
     * 绘制圆形图片
     * @author caizhiming
     */
    private int rangle = 0;
    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();
        if (null != drawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap b = getCircleBitmap(bitmap,10);
            final Rect rectSrc = new Rect(0, 0, b.getHeight(), b.getHeight());
            final Rect rectDest = new Rect(0,0,getWidth(),getWidth());


            //画底圆
            int r = getWidth() / 2;
            paint.reset();
            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            canvas.drawCircle(r,r,r,paint);

            //画进度条
            int strokWidth = 20;
            int i = strokWidth / 2;
            paint.reset();
            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(strokWidth);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(new RectF(0+i,0+ i,getWidth()-i,getWidth()-i),-90, currentProgress,false,paint);

            //画图片
            paint.reset();
            canvas.drawBitmap(b, rectSrc, rectDest, paint);

            mHandler.sendEmptyMessageDelayed(0,20);
        } else {
            super.onDraw(canvas);
        }
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mHandler.removeMessages(0);
            rangle += 1;
            if(rangle > 360){
                rangle = 0;
            }
            invalidate();
        }
    };




    /**
     * 获取圆形图片方法
     * @param bitmap
     * @param pixels
     * @return Bitmap
     * @author caizhiming
     */
    private Bitmap getCircleBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getHeight(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;

        final Rect rect = new Rect(0, 0, bitmap.getHeight(), bitmap.getHeight());
        paint.reset();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        int x = bitmap.getHeight();
        if(isSrcRatote){
            canvas.rotate(rangle,x/2,x/2);
        }

        canvas.drawCircle(x / 2, x / 2, x / 2-pixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public float getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(float currentProgress) {
        this.currentProgress = currentProgress * 360/allProgress;
    }

    public boolean isSrcRatote() {
        return isSrcRatote;
    }

    public void setSrcRatote(boolean srcRatote) {
        isSrcRatote = srcRatote;
    }

    public float getAllProgress() {
        return allProgress;
    }

    public void setAllProgress(float allProgress) {
        if(allProgress == 0){
            return;
        }
        this.allProgress = allProgress;
    }


}
