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
        if (url.indexOf("http") == 0) {     //The url is a internet url.
            byte[] result = InternetOperator.getPhotoFomInternet(url);
            try {
                Bitmap bm = BitmapUtils.decodeSampledBitmapFromByteArray(result, 200, 200);
                getImageCallable.onGetImage(bm);
            } catch (Exception e) {

            }
        }
        else{
            byte[] photo = GetFile.getLocalPhotoByName(url);
            Bitmap bm = BitmapUtils.decodeSampledBitmapFromByteArray(photo, 200, 200);
            getImageCallable.onGetImage(bm);
        }
        Log.d("Gotten photo from", url);
        workDoneCallback.workDone(url);
    }
}
