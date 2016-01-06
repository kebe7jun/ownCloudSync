package com.kebe7jun.data.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by nie2nie2 on 16-1-4.
 */
public class getInfoFromWeb {
    /**
     * get the info after logining.
     */
    private static String LOGIN_URL = "https://data.kebe7jun.com/";

    public String simulateLogin(String user, String password){
        String msg = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(LOGIN_URL).openConnection();
            conn.setRequestMethod("POST");//set mode
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);   //"POST" mode cant't use caches
            conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            conn.connect();     //set connect
            OutputStream os = conn.getOutputStream();
            String data = "user=" + URLEncoder.encode(user, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8");
            os.write(data.getBytes());
            os.flush();
            if(conn.getResponseCode() == 302){
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream message = new ByteArrayOutputStream();
                int len = 0;
                byte buffer[] = new byte[1024];
                while((len = is.read(buffer)) != -1){
                    message.write(buffer, 0, len);
                }
                is.close(); //free
                message.close();
                msg = new String(message.toByteArray());
                conn.disconnect();
                return  msg;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
