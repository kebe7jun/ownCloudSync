package com.kebe7jun.data.ui;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kebe7jun.data.code.ConstantCode;
import com.kebe7jun.data.web.JavaScriptInterface;
import com.kebe7jun.data.web.OwnCloudWebviewClient;

/**
 * Created by kebe on 15-12-3.
 */
public class WebViewFragment extends Fragment {

    private View view;
    private WebView webView;
    private WebSettings webSettings;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            this.view = inflater.inflate(R.layout.fragment_web_view, container, false);
            webView = (WebView) view.findViewById(R.id.webView);

            this.webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);     //Set javascript enable.
            webSettings.setUserAgentString(ConstantCode.USER_AGENT);    //Set useragent of this App.
            webSettings.setAllowFileAccess(true);       //Set can read file.
            webSettings.setDomStorageEnabled(true);

            webView.addJavascriptInterface(new JavaScriptInterface(webView), ConstantCode.JS_OBJECT_NAME);
            webView.setWebViewClient(new OwnCloudWebviewClient());
            webView.loadUrl(ConstantCode.cloudUrl+"index.php/apps/files/");       //Init page

        }
        return view;
    }

}
