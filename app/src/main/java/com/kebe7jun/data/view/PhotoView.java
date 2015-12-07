package com.kebe7jun.data.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.kebe7jun.data.code.ConstantCode;
import com.kebe7jun.data.interfaces.GetImageCallable;

/**
 * Created by kebe on 15-12-5.
 */
public class PhotoView extends ImageView implements GetImageCallable{

    /**
     * The image source url.
     */
    private String imageSourceUrl;

    private Context context;

    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setViewStyle();
    }

    /**
     * If you want to show a photo from internet on this view, you must call this function.
     * The url must fallow the rule of http url protocol.
     * @param imageSourceUrl
     */
    public void setImageImternetSourceUrl(String imageSourceUrl){
        this.imageSourceUrl = imageSourceUrl;
    }

    /**
     * Set the style of this image view.
     */
    private void setViewStyle(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = display.getWidth()/ ConstantCode.COLS_EACH_LINE;
        layoutParams.height = display.getHeight()/ConstantCode.COLS_EACH_LINE;
        setLayoutParams(layoutParams);
    }

    @Override
    public void onGetImage(byte[] result) {
        Bitmap bm = BitmapFactory.decodeByteArray(result, 0, result.length);
        setImageBitmap(bm);
    }

}
