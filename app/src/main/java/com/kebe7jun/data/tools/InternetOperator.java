package com.kebe7jun.data.tools;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kebe on 15-12-5.
 */
public class InternetOperator {

    /**
     * Set the timeout of HTTP connection.
     */
    private final int CONNECT_TIME_OUT = 5000;

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
