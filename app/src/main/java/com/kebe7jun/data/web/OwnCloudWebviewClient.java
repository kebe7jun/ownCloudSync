package com.kebe7jun.data.web;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kebe7jun.data.code.ConstantCode;

/**
 * Created by kebe on 15-12-3.
 */
public class OwnCloudWebviewClient extends WebViewClient {

    /**
     * To get web source code, we need run js code.
     */
    private final String GET_SOURCE_CODE_CODE = "javascript:window."+ ConstantCode.JS_OBJECT_NAME+".showSource('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');";

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.d("WebViewEnvent", "Loading "+url);
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) { //To load url in this webview.
        view.loadUrl(url);
        return true;
    }
    public void onPageFinished(WebView view, String url) {
        Log.d("WebViewEnvent", "Loaded "+url);
        view.loadUrl(GET_SOURCE_CODE_CODE);     //To check login, analysis the source code.
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        Log.w("Get url error code(", errorResponse.getStatusCode()+")");
    }
}
