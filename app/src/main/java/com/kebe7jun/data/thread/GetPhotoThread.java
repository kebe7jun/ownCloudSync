package com.kebe7jun.data.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.kebe7jun.data.interfaces.GetImageCallable;
import com.kebe7jun.data.tools.BitmapUtils;
import com.kebe7jun.data.tools.GetFile;
import com.kebe7jun.data.tools.InternetOperator;
import com.kebe7jun.data.tools.Tools;

/**
 * Created by kebe on 15-12-7.
 */
public class GetPhotoThread implements Runnable {

    private String url;
    private GetImageCallable getImageCallable;
    public GetPhotoThread(String url, GetImageCallable getImageCallable){
        this.getImageCallable = getImageCallable;
        this.url = url;
    }

    @Override
    public void run() {
        Log.d("Gotten photo from", url);
        if (url.indexOf("http") == 0) {     //The url is a internet url.
            byte[] result = InternetOperator.getPhotoFomInternet(url);
            try {
                getImageCallable.onGetImage(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            byte[] photo = GetFile.getLocalPhotoByName(url);
            Bitmap bm = BitmapUtils.decodeSampledBitmapFromByteArray(photo, 20, 200);
            getImageCallable.onGetImage(bm);
        }
    }
}
