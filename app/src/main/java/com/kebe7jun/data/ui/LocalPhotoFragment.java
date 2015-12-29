package com.kebe7jun.data.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.kebe7jun.data.adapter.LocalPhotosShowAdapter;
import com.kebe7jun.data.tools.GetFile;
import com.kebe7jun.data.view.PhotoView;

import java.util.List;

/**
 * Created by kebe on 15-12-5.
 */
public class LocalPhotoFragment extends Fragment {

    private View view;
    private ListView listView;
    private LocalPhotosShowAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_local_photo, container, false);   //Set view layout.

            swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);
            swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                }
            });
            swipeRefresh.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                    android.R.color.holo_orange_light, android.R.color.holo_red_light);
//            swipeRefresh.setDistanceToTriggerSync(400);
            swipeRefresh.setSize(SwipeRefreshLayout.LARGE);
            List<String> photos = GetFile.getAllLocalPhotosName();
            listView = (ListView)view.findViewById(R.id.localPhotoListView);
            adapter = new LocalPhotosShowAdapter(getActivity(), photos, R.layout.item_photo_row);
            listView.setAdapter(adapter);
        }
        return view;
    }
}
