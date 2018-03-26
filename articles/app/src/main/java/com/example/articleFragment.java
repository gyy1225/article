package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.jsoup.nodes.Document;

/**
 * Created by ASUS on 2018/3/25.
 */

public class articleFragment extends Fragment implements Runnable {
    Activity mActivity;
    AppCompatActivity mAppCompatActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_frag, container, false);
        mActivity = getActivity();
        AppCompatActivity mAppCompatActivity = (AppCompatActivity) mActivity;
        Toolbar toolbar = (Toolbar) mAppCompatActivity.findViewById(R.id.toolbar);
        mAppCompatActivity.setSupportActionBar(toolbar);
        FloatingActionButton random=(FloatingActionButton)view.findViewById(R.id.random);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"成功刷新",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void run() {

    }
}



