package com.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2018/3/28.
 */

public class savedArticlesAdapter extends ArrayAdapter<article> {
        private Context mContext;
        private int mresourceId;
        private List<article> mArticleList;
        TextView savedTitle;
        TextView savedAuthor;

        public savedArticlesAdapter(Context context, int resourceId, List<article> objects) {
            super(context, resourceId, objects);
            mContext=context;
            mArticleList=objects;
            mresourceId = resourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            article marticle=getItem(position);
            View view= LayoutInflater.from(getContext()).inflate(mresourceId,parent,false);
            savedTitle=(TextView)view.findViewById(R.id.tv_savedTitle);
            savedAuthor=(TextView)view.findViewById(R.id.tv_savedAuthor);
            savedAuthor.setText(marticle.getAuthor());
            savedTitle.setText(marticle.getTitle());
            return view;
        }
    }



