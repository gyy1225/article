package com.example;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.logging.LogRecord;

/**
 * Created by ASUS on 2018/3/25.
 */

public class articleAdapter extends ArrayAdapter<article> {
    private Context mContext;
    private int mresourceId;
    private List<article> mArticleList;
    RecyclerView recyclerView1;
    TextView tv_title;
    TextView tv_author;
    TextView tv_text;
    Button download;

    public articleAdapter(Context context, int resourceId, List<article> objects) {
        super(context, resourceId, objects);
        mContext=context;
        mresourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        article marticle=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(mresourceId,parent,false);
        tv_text=(TextView)view.findViewById(R.id.tv_text);
        tv_author=(TextView)view.findViewById(R.id.tv_author);
        tv_title=(TextView)view.findViewById(R.id.tv_title);
        download = (Button) view.findViewById(R.id.btn_download);
        String txt;
        txt = marticle.getText();
        tv_text.setText(txt);
        tv_author.setText(marticle.getAuthor());
        tv_title.setText(marticle.getTitle());
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                article articleSave=new article();
                articleSave.setTitle(tv_title.getText().toString());
                articleSave.setAuthor( tv_author.getText().toString());
                articleSave.setText(tv_text.getText().toString());
                /*List<book> mbooks= DataSupport.findAll(book.class);*/
               /*for(book aBook:mbooks){
                   if (aBook.getTitle().toString()==articleSave.getTitle().toString()){
                       Toast.makeText(mContext,"已经下载过啦",Toast.LENGTH_LONG).show();
                       break;
                   }

               }*/
                articleSave.save();
                Toast.makeText(mContext, "成功下载", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

