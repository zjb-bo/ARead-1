package com.aread.cn.bean;

import java.io.File;

/**
 * Created by Administrator on 2017/6/5.
 */
public class UserImagerUrlBean {
    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    private File imageFile;

    public UserImagerUrlBean(File file) {
        this.imageFile = file;
    }
}
