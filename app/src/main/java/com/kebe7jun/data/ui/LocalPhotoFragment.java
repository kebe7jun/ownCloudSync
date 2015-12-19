package com.kebe7jun.data.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.kebe7jun.data.adapter.LocalPhotosShowAdapter;
import com.kebe7jun.data.tools.GetFile;

import java.util.List;

/**
 * Created by kebe on 15-12-5.
 */
public class LocalPhotoFragment extends Fragment {

    private View view;
    private ListView listView;
    private LocalPhotosShowAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)view.findViewById(R.id.localPhotoListView);
        List<String> photos = GetFile.getAllLocalPhotosName();
//        for (int i = 1; i<photos.size(); i++){
//            photos.remove(i);
//        }
        adapter = new LocalPhotosShowAdapter(getActivity(), photos, R.layout.item_photo_row);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_local_photo, container, false);
        }
        return view;
    }
}
