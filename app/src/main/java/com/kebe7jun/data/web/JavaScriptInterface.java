package com.kebe7jun.data.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.kebe7jun.data.code.ConstantCode;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kebe on 15-12-3.
 */
public class JavaScriptInterface {

    private WebView webView;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case ConstantCode.MSG_DO_LOGIN:
                    String postData = msg.getData().getString("postData");
                    try {
                        webView.postUrl(ConstantCode.cloudUrl, postData.getBytes("utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    public JavaScriptInterface(WebView webView){
        this.webView = webView;
    }
    /**
     * To be sure JS can use the function, must add @JavascriptInterface.
     */
    @JavascriptInterface
    public void showSource(String html){
        //On got html source code.
        if (html.contains("name=\"user\"") && html.contains("name=\"password\"")){
            doLogin(html);
        }
    }

    private void doLogin(String html){
        Message message = new Message();
        message.what = ConstantCode.MSG_DO_LOGIN;
        Bundle b = new Bundle();
        Pattern p = Pattern.compile("name=\"requesttoken\" value=\"(.*)\"");        //正则提取requesttoken
        Matcher m = p.matcher(html);
        String requesttoken = "";
        if (m.find()){
            String str = m.group();
            requesttoken = str.substring(27, str.length()-1);
        }
        Log.d("requesttoken", requesttoken);
        String postStr = "user="+ConstantCode.userName      // Build post data.
                +"&password="+ConstantCode.password
                +"&timezone-offset=8"
                +"&timezone=Asia/Krasnoyarsk"
                +"&requesttoken="+requesttoken;
        b.putString("postData", postStr);
        message.setData(b);
        handler.sendMessage(message);
    }

}
