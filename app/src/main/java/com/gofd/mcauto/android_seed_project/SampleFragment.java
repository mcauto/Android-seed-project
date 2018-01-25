package com.gofd.mcauto.android_seed_project;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.ionicons_typeface_library.Ionicons;


/**
 * Created by mcauto on 2017-09-03.
 */

public class SampleFragment extends Fragment{
    public SampleFragment(){

    }
    public static SampleFragment newInstance(){
        return new SampleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample,container,false);
        initToolbar(view);
        return view;
    }
    private void initToolbar(View view){
        if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getActivity().getWindow().setStatusBarColor(Color.BLACK);
        }
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("");

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        TextView title = toolbar.findViewById(R.id.title);
        title.setText("main");
    }

}

