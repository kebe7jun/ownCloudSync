package com.kebe7jun.data.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.kebe7jun.data.object.OWFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kebe on 15-12-5.
 */
public class   InternetOperator {

    /**
     * Set the timeout of HTTP connection.
     */
    private static final int CONNECT_TIME_OUT = 5000;

//    public static byte[] getPhotoPreview(OWFile owFile, Context context){
//        //Example url: https://data.kebe7jun.com/index.php/core/preview.png?file=%2FPhotos%2FParis.jpg&c=b54d82b672f85eaa76c6224c67cb8c28&x=32&y=32&forceIcon=0
//
//    }
    /**
     * Download photo from gotten url and return a byte array.
     * @param url
     * @return
     */
    public static byte[] getPhotoFomInternet(String url){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Log.d("Get image form internet", url);

            HttpURLConnection con = (HttpURLConnection) ( new URL(url)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setConnectTimeout(CONNECT_TIME_OUT);
            con.connect();

            InputStream is = con.getInputStream();
            byte[] b = new byte[1024];

            while ( is.read(b) != -1)
                baos.write(b);
            con.disconnect();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return baos.toByteArray();
    }
}
