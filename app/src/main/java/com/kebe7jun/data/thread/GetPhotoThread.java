package com.kebe7jun.data.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.util.Log;

import com.kebe7jun.data.config.AppSetting;
import com.kebe7jun.data.interfaces.GetImageCallable;
import com.kebe7jun.data.interfaces.WorkDoneCallback;
import com.kebe7jun.data.tools.BitmapUtils;
import com.kebe7jun.data.tools.GetFile;
import com.kebe7jun.data.tools.InternetOperator;
import com.kebe7jun.data.tools.Tools;

/**
 * Created by kebe on 15-12-7.
 */
public class GetPhotoThread implements Runnable {

    /**
     * The url to get.
     */
    private String url;
    /**
     * Call UI thread.
     */
    private GetImageCallable getImageCallable;
    /**
     * When this work done, tell thread pool.
     */
    private WorkDoneCallback workDoneCallback;
    public GetPhotoThread(String url, GetImageCallable getImageCallable, WorkDoneCallback workDoneCallback){
        this.getImageCallable = getImageCallable;
        this.url = url;
        this.workDoneCallback = workDoneCallback;
    }

    @Override
    public void run() {
        byte[] photo = null;
        if (url.indexOf("http") == 0) {     //The url is a internet url.
            if ((photo = GetFile.getCachedPhotoByUrl(url)) == null) {
                photo = InternetOperator.getPhotoFomInternet(url);
                GetFile.cacheFileFromInternet(url, photo);     //Cache file to local cache.
                try {
                    Bitmap bm = BitmapUtils.decodeSampledBitmapFromByteArray(photo, 200, 200);
                    getImageCallable.onGetImage(bm);
                } catch (Exception e) {

                }
                Log.d("Photo gotten", "from "+url);
            }
            else {
                try {
                    Bitmap bm = BitmapUtils.decodeSampledBitmapFromByteArray(photo, 200, 200);
                    getImageCallable.onGetImage(bm);
                } catch (Exception e) {

                }
                Log.d("Photo gotten", "from cached file.");
            }
        }
        else{
            photo = GetFile.getLocalPhotoByName(url);
            Bitmap bm = BitmapUtils.decodeSampledBitmapFromByteArray(photo, 200, 200);
            getImageCallable.onGetImage(bm);
            Log.d("Photo gotten", "from local file.");
        }
        workDoneCallback.workDone(url);
    }
}
