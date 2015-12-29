package com.kebe7jun.data.adapter;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.ViewGroup;

import com.kebe7jun.data.config.AppSetting;
import com.kebe7jun.data.tools.GetFile;
import com.kebe7jun.data.ui.R;
import com.kebe7jun.data.view.PhotoView;

import java.util.List;

/**
 * Created by kebe on 15-12-8.
 */
public class LocalPhotosShowAdapter extends CommonAdapter<String> {

    public LocalPhotosShowAdapter(Activity activity, List<String> data, int layoutId) {
        super(activity, data, layoutId);
    }

    @Override
    public int getCount() {
        return super.getCount()/3+(super.getCount()%3==0?0:1);
    }

    /**
     * Set each view.
     * @param myViewHolder
     * @param s
     */
    @Override
    public void setConverView(CommonViewHolder myViewHolder, String s) {
        PhotoView photoView1 = (PhotoView)myViewHolder.getConvertView().findViewById(R.id.imageView1);
        photoView1.setImageResource(R.mipmap.ic_launcher);
        photoView1.setPhotoLocal(data.get(myViewHolder.getPosition()*3));
        photoView1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(AppSetting.getDeviceScreenWidth()/3-10, AppSetting.getDeviceScreenWidth()/3));
        if (myViewHolder.getPosition()*3+1<data.size()) {
            PhotoView photoView2 = (PhotoView) myViewHolder.getConvertView().findViewById(R.id.imageView2);
            photoView2.setImageResource(R.mipmap.ic_launcher);
            photoView2.setPhotoLocal(data.get(myViewHolder.getPosition()*3+1));
            photoView2.setLayoutParams(new android.widget.LinearLayout.LayoutParams(AppSetting.getDeviceScreenWidth()/3-10, AppSetting.getDeviceScreenWidth()/3));
        }
        if (myViewHolder.getPosition()*3+2<data.size()) {
            PhotoView photoView3 = (PhotoView) myViewHolder.getConvertView().findViewById(R.id.imageView3);
            photoView3.setImageResource(R.mipmap.ic_launcher);
            photoView3.setPhotoLocal(data.get(myViewHolder.getPosition()*3+2));
            photoView3.setLayoutParams(new android.widget.LinearLayout.LayoutParams(AppSetting.getDeviceScreenWidth()/3-10, AppSetting.getDeviceScreenWidth()/3));
        }
    }
}
