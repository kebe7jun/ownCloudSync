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
     * Final area.
     */
    public static final String JS_OBJECT_NAME = "OwnCloudJSObj";

    /**
     * Do login.
     */
    public static final int MSG_DO_LOGIN = 0x0001;

    public static final int GET_IMAGE_SUCCESS = 0x0002; //Get photo success
    public static final int GET_IMAGE_ERROR = 0x0a02;       //Get photo error.

    /**
     * WebView Setting.
     */
    public static final String USER_AGENT = "ownCloudSync Client Android Version(" + BuildConfig.VERSION_NAME + ") --- KEBE";

    /**
     * Self MIME TYPE in this app.
     * To have a good extends.
     */
    public static final String SELF_MIME_TYPE_IMAGE = ".pic";
}
