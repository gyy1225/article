package com.example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
 * Created by ASUS on 2018/3/25.
 */

public class bookAdapter extends ArrayAdapter<book>{
    private int resourceId;
    Context mContext;

    public bookAdapter( Context context, int resource,  List<book> objects) {
        super(context, resource, objects);
        mContext=context;
        resourceId=resource;
    }

    @Override
    public View getView(int position,View convertView,  ViewGroup parent) {
        book mbook=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView bookImage=(ImageView)view.findViewById(R.id.book_image);
        TextView bookTitle=(TextView)view.findViewById(R.id.book_title);
        TextView bookAuthor=(TextView)view.findViewById(R.id.book_author);
        Glide.with(mContext).load(mbook.getImageURL()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(bookImage);
        bookTitle.setText(mbook.getTitle());
        bookAuthor.setText(mbook.getAuthor());
        return view;
    }
}
