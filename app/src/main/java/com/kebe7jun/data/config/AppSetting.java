package com.kebe7jun.data.config;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import com.kebe7jun.data.tools.GetFile;
import com.kebe7jun.data.ui.R;

import java.util.List;

/**
 * Created by kebe on 15-12-7.
 */
public class AppSetting {

    /**
     * Screen width(px).
     */
    private static int deviceScreenWidth = 1080;
    private static int deviceScreenHeight = 1920;


    /**
     * Init app and set some vars.
     * @param activity
     */
    public static void initApp(Activity activity){
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        setDeviceScreenWidth(width);
        setDeviceScreenHeight(height);
    }

    /**
     * Get screen width.
     * @return
     */
    public static int getDeviceScreenWidth() {
        return deviceScreenWidth;
    }

    /**
     * Set screen width
     * @param deviceScreenWidth
     */
    public static void setDeviceScreenWidth(int deviceScreenWidth) {
        AppSetting.deviceScreenWidth = deviceScreenWidth;
    }

    /**
     * Get screen height.
     * @return
     */
    public static int getDeviceScreenHeight() {
        return deviceScreenHeight;
    }

    /**
     * Set screen height.
     * @param deviceScreenHeight
     */
    public static void setDeviceScreenHeight(int deviceScreenHeight) {
        AppSetting.deviceScreenHeight = deviceScreenHeight;
    }

    /**
     * Get the username of ownCloud.
     * @param context
     * @return
     */
    public static String getOwnCloudUsername(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(context.getResources().getString(R.string.owncloud_username), context.getResources().getString(R.string.owncloud_username_default));
    }

    /**
     * Get the password of ownCloud.
     * @param context
     * @return
     */
    public static String getOwnCloudPassword(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(context.getResources().getString(R.string.owncloud_password), context.getResources().getString(R.string.owncloud_password_default));
    }

    /**
     * Get the host url of ownCloud.
     * @param context
     * @return
     */
    public static String getOwnCloudHostUrl(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(context.getResources().getString(R.string.owncloud_host_url), context.getResources().getString(R.string.owncloud_host_url_default));
    }

    /**
     * Get the photo sync dir of ownCloud.
     * @param context
     * @return
     */
    public static String getPhotoSyncDir(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(context.getResources().getString(R.string.owncloud_sync_dir), context.getResources().getString(R.string.owncloud_sync_dir_default));
    }
}
