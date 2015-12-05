package com.kebe7jun.data.tools;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KEBE on 11/24/2015.
 */
public class CommonViewHolder {
    private SparseArray<View> sparseArray;
    private View convertView;
    private int position;

    public CommonViewHolder(Activity activity, View convertView, int layoutId, ViewGroup parent, int position) {
        this.position = position;
        this.sparseArray = new SparseArray<View>();
        this.convertView = LayoutInflater.from(activity).inflate(layoutId, parent, false);
        this.convertView.setTag(this);
    }

    public static CommonViewHolder getCommonViewHolder(Activity activity, View convertView, int layoutId, ViewGroup parent, int position) {
        if (convertView == null) {
            return new CommonViewHolder(activity, convertView, layoutId, parent, position);
        } else {
            CommonViewHolder commonViewHolder = (CommonViewHolder) convertView.getTag();
            commonViewHolder.position = position;
            return commonViewHolder;
        }
    }

    public <T extends View> T getView(int viewId) {
        View view = sparseArray.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            sparseArray.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * To get convert view
     * @return
     */
    public View getConvertView(){
        return convertView;
    }

}