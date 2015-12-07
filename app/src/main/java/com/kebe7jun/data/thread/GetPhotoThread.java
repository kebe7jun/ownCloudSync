package com.kebe7jun.data.thread;

import com.kebe7jun.data.interfaces.GetImageCallable;
import com.kebe7jun.data.tools.InternetOperator;

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
        byte[] result = InternetOperator.getPhotoFomInternet(url);
        try {
            getImageCallable.onGetImage(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
