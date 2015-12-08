package com.kebe7jun.data.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
        return super.getCount()/3+super.getCount()%3==0?0:1;
    }

    @Override
    public void setConverView(CommonViewHolder myViewHolder, String s) {
        PhotoView photoView1 = (PhotoView)myViewHolder.getConvertView().findViewById(R.id.imageView1);
        photoView1.setPhotoLocal(s);
    }
}
