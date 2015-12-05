package com.kebe7jun.data.code;

import com.kebe7jun.data.ui.BuildConfig;

/**
 * Created by kebe on 15-12-2.
 */
public class ConstantCode {

    /**
     * Setting value
     */
    public static String cloudUrl = "https://data.kebe7jun.com/";
    public static String userName = "test";     //From setting.
    public static String password = "test";     //From setting.
    public static String photoUrl = "";

    /**
     * Cache photo path.
     */
    public static final String CACHE_PHOTO_PATH = "/sdcard/ownCloudSync/";

    /**
     * Only sync photo in wlan network.
     */
    public static boolean isOnlySyncInWlan = true;


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
