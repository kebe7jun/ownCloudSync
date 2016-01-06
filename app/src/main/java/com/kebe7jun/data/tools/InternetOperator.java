package com.kebe7jun.data.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kebe7jun.data.config.AppSetting;
import com.kebe7jun.data.object.OWFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by kebe on 15-12-5.
 */
public class   InternetOperator {

    /**
     * Set the timeout of HTTP connection.
     */
    private static final int CONNECT_TIME_OUT = 5000;

    public static byte[] getPhotoPreview(@Nullable OWFile owFile, Context context){
        //Example url: https://data.kebe7jun.com/index.php/core/preview.png?file=%2FPhotos%2FParis.jpg&c=b54d82b672f85eaa76c6224c67cb8c28&x=32&y=32&forceIcon=0
        String url = "https://blog.kebe7jun.com/wp-content/uploads/2015/01/QQ%E6%88%AA%E5%9B%BE20150130232610.png";
//        url = AppSetting.getOwnCloudHostUrl(context)
//                +"/index.php/core/preview.png?file="
//                + URLEncoder.encode(AppSetting.getPhotoSyncDir(context)+"/"+owFile.getName())
//                +"&c="
//                +owFile.getEtag()
//                +"&x=200&y=200&forceIcon=0";
        return getPhotoFomInternet(url);
    }

    /**
     * Download photo from gotten url and return a byte array.
     * @param url
     * @return
     */
    public static byte[] getPhotoFomInternet(String url){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Log.d("Getting image form", url);
            HttpURLConnection con = (HttpURLConnection) ( new URL(url)).openConnection();
            con.setDoInput(true);
            con.setConnectTimeout(CONNECT_TIME_OUT);
            con.connect();

            InputStream is = con.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ( (len = is.read(b)) != -1)
                baos.write(b, 0, len);
            baos.flush();
            is.close();
            con.disconnect();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return baos.toByteArray();
    }
}
