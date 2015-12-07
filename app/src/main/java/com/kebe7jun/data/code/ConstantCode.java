package com.kebe7jun.data.code;

import com.kebe7jun.data.ui.BuildConfig;

/**
 * Created by kebe on 15-12-2.
 */
public class ConstantCode {

    /**
     * This var show how many photos will show on line.
     */
    public static final int COLS_EACH_LINE = 3;

    /**
     * The count of the thread pool to complete internet operator and get image.
     */
    public static final int INTERNET_THREADS_COUNT = 5;

    /**
     * Cache photo path.
     */
    public static final String CACHE_PHOTO_PATH = "/sdcard/ownCloudSync/";

    /**
     * Final area.
     */
    public static final String JS_OBJECT_NAME = "OwnCloudJSObj";

    /**
     * Do login.
     */
    public static final int MSG_DO_LOGIN = 0x0001;

    /**
     * WebView Setting.
     */
    public static final String USER_AGENT = "ownCloudSync Client Android Version(" + BuildConfig.VERSION_NAME + ") --- KEBE";
}
