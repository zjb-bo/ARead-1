package com.aread.cn.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.aread.cn.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;



/**
 * Created by Administrator on 2017/3/29.
 */

public class UmengLoginShareUtils {

    private static UmengLoginShareUtils umengLoginShareUtils;
    private Activity context;

    private UmengLoginShareUtils(Activity context){
        this.context = context;
    }

    public static UmengLoginShareUtils getInstance(Activity context){
        if(umengLoginShareUtils == null){
            umengLoginShareUtils = new UmengLoginShareUtils(context);
        }
        return umengLoginShareUtils;
    }

    /**
     * 打开分享面板
     * @param content
     */
    public void shareOpen(String content){
        new ShareAction(context)
                .withText("生活那么美，一定有你想记录的！"+content)
                .withMedia(new UMImage(context, R.mipmap.a_read_logo))
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.SINA,SHARE_MEDIA.YNOTE,SHARE_MEDIA.EVERNOTE)
                .setCallback(umShareListener)
                .open();
    }

    /**
     * 三方授权登录
     * @param type
     */
    public void thirdLogin(SHARE_MEDIA type){
        UMShareAPI.get(context).getPlatformInfo(context,type, umAuthListener);
    }

    /**
     * 授权结果监听
     */
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Toast.makeText(context, share_media+"开始授权...", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(context, share_media+"授权成功...", Toast.LENGTH_SHORT).show();
            Set<String> strings = map.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                Log.e("zjb", "KEY:"+next+",value:"+map.get(next));
            }
        }
        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Toast.makeText(context,  share_media+"授权失败...", Toast.LENGTH_SHORT).show();
            Log.e("zjb", "授权失败,i:"+i+",throwable:"+throwable.getMessage());


        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText(context,  share_media+"授权取消...", Toast.LENGTH_SHORT).show();

        }
    };

    /**
     * 分享结果监听
     */
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Toast.makeText(context, share_media+"开始分享...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Toast.makeText(context, share_media+"分享成功...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Toast.makeText(context,  share_media+"分享失败...", Toast.LENGTH_SHORT).show();
            Log.e("zjb", "分享失败,"+" throwable:"+throwable.getMessage());

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Toast.makeText(context,  share_media+"分享取消...", Toast.LENGTH_SHORT).show();
        }
    };

}
