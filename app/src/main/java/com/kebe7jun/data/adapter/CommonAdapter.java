package com.kebe7jun.data.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kebe7jun.data.tools.CommonViewHolder;

import java.util.List;

/**
 * Created by KEBE on 11/24/2015.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Activity activity;
    protected LayoutInflater layoutInflater;
    protected List<T> data;
    protected int layoutId;

    public CommonAdapter(Activity activity, List<T> data, int layoutId) {
        this.activity = activity;
        this.layoutInflater = LayoutInflater.from(activity);
        this.data = data;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonViewHolder myViewHolder = new CommonViewHolder(activity, convertView, layoutId, parent, position);
        setConverView(myViewHolder, data.get(position));
        return myViewHolder.getConvertView();
    }

    public abstract void setConverView(CommonViewHolder myViewHolder, T t);
}