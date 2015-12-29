package com.kebe7jun.data.config;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import com.kebe7jun.data.ui.R;


/**
 * Created by kebe on 15-12-7.
 */
public class AppSetting {

    /**
     * Screen size params.
     */
    private static ViewGroup.LayoutParams deviceScreenParams;


    /**
     * Init app and set some vars.
     * @param activity
     */
    public static void initApp(Activity activity){
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        setDeviceScreenParams(new ViewGroup.LayoutParams(width, height));
    }

    /**
     * Set screen size params.
     * @param params
     */
    public static void setDeviceScreenParams(ViewGroup.LayoutParams params){
        deviceScreenParams = new ViewGroup.LayoutParams(params.width, params.height);
    }

    /**
     * Get screen size params.
     * @return
     */
    public static ViewGroup.LayoutParams getDeviceScreenParams(){
        return deviceScreenParams;
    }

    /**
     * Get screen width.
     * @return
     */
    public static int getDeviceScreenWidth() {
        return deviceScreenParams.width;
    }

    /**
     * Get screen height.
     * @return
     */
    public static int getDeviceScreenHeight() {
        return deviceScreenParams.height;
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
