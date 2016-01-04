package com.kebe7jun.data.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kebe7jun.data.code.ConstantCode;
import com.kebe7jun.data.config.AppSetting;
import com.kebe7jun.data.interfaces.GetImageCallable;
import com.kebe7jun.data.thread.GetPhotoThreadPool;
import com.kebe7jun.data.tools.GetFile;
import com.kebe7jun.data.ui.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by kebe on 15-12-5.
 */
public class PhotoView extends ImageView implements GetImageCallable{

    /**
     * The image source url.
     */
    private String imageSourceUrl;

    /**
     * Is need compression.
     */
    private boolean isNeedCompression = true;

    /**
     * The margin of each PhotoView.
     */
    private final int MARGIN_WIDTH = 10;

    private Context context;
    private Bitmap bitmap;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case ConstantCode.GET_IMAGE_SUCCESS:
                    setImageBitmap(bitmap);
                    break;
                case ConstantCode.GET_IMAGE_ERROR:
                    setImageResource(R.drawable.ic_menu_share);
                    break;
            }
        }
    };

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context; //Save context
    }

    /**
     * If you want to show a photo from internet on this view, you must call this function.
     * The url must fallow the rule of http url protocol.
     * @param imageSourceUrl
     */
    public void setImageImternetSourceUrl(String imageSourceUrl){
        setPhotoUrl(imageSourceUrl);
    }

    /**
     * Set photo url, is can be like IMG12312.jpg, also can be like https://blog.kebe7jun.com/preview....
     * This method will cut the source photo to a square photo and the width & height below 200px.
     * @param imageSourceUrl
     */
    public void setPhotoUrl(String imageSourceUrl){
        this.imageSourceUrl = imageSourceUrl;
        //Set the view style before load image.
        setViewStyle();
        //Load photo async.
        GetPhotoThreadPool.getImage(imageSourceUrl, this);
    }

    /**
     * Set the style of this image view.
     */
    public void setViewStyle(){
        //Set view's params.
        LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(
                AppSetting.getDeviceScreenWidth()/3 - MARGIN_WIDTH * 2,     //The width according the margin.
                AppSetting.getDeviceScreenWidth()/3);
        layoutParams.setMargins(MARGIN_WIDTH, 0, MARGIN_WIDTH, 0);      //Set left and right margin.
        setLayoutParams(layoutParams);      //Apply the LayoutParams to this view.
    }

    /**
     * If a photo gotten from internet or file, call this function.
     * @param bitmap
     */
    @Override
    public void onGetImage(Bitmap bitmap) {
        Message msg = new Message();
        if (bitmap != null){
            this.bitmap = bitmap;       //Set bitmap.
            msg.what = ConstantCode.GET_IMAGE_SUCCESS;
        }
        else {
            msg.what = ConstantCode.GET_IMAGE_ERROR;
        }
        handler.sendMessage(msg);       //Call UI thread to set bitmap
    }

    /**
     * Set is need compression.
     * @param isNeedCompression
     */
    public void setNeedCompression(boolean isNeedCompression){
        this.isNeedCompression = isNeedCompression;
    }
}
