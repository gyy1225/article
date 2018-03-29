package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by ASUS on 2018/3/29.
 */

public class menuAdapter extends ArrayAdapter<menu> {
        private int resourceId;
        Context mContext;

        public menuAdapter( Context context, int resource,  List<menu> objects) {
            super(context, resource, objects);
            mContext=context;
            resourceId=resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            menu mMenu=getItem(position);
            View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            ImageView menuImage=(ImageView)view.findViewById(R.id.iv_menuImage);
            TextView menu=(TextView)view.findViewById(R.id.tv_menu);
            menu.setText(mMenu.getMenu());
            Glide.with(mContext).load(mMenu.getImageURL()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(menuImage);
            return view;
        }
    }
