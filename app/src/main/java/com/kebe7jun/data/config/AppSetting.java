package com.kebe7jun.data.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kebe7jun.data.ui.R;

/**
 * Created by kebe on 15-12-7.
 */
public class AppSetting {

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
