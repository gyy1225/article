package com.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import org.jsoup.nodes.Document;

/**
 * Created by ASUS on 2018/3/25.
 */

public class articleFragment extends Fragment {
    Activity mActivity;
    Button download;
    article currentArticle=new article();
    AppCompatActivity mAppCompatActivity;
    articleAdapter marticleAdapter;
    ListView mListView;
    Boolean refresh = false;
    List<article> mArticleList1 = new ArrayList<>();
    @SuppressLint("HandleeLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    article articles = (article) msg.obj;
                    currentArticle=articles;
                    mArticleList1.add(articles);
                    marticleAdapter = new articleAdapter(getActivity(), R.layout.article_item, mArticleList1);
                    mListView.setAdapter(marticleAdapter);
                    break;

                case 2:
                    article ranArticle = (article) msg.obj;
                    currentArticle=ranArticle;
                    mArticleList1.clear();
                    mArticleList1.add(ranArticle);
                    marticleAdapter.notifyDataSetChanged();
                    //marticleAdapter = new articleAdapter(getActivity(), R.layout.article_item, mArticleList1);
                    mListView.setAdapter(marticleAdapter);
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_frag, container, false);
        mActivity = getActivity();
        AppCompatActivity mAppCompatActivity = (AppCompatActivity) mActivity;
        Toolbar toolbar = (Toolbar) mAppCompatActivity.findViewById(R.id.toolbar);
        mListView=(ListView)view.findViewById(R.id.lv_article);
        initArticle(0);
        mAppCompatActivity.setSupportActionBar(toolbar);
        FloatingActionButton random = (FloatingActionButton) view.findViewById(R.id.random);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh=true;
                initArticle((1));
                Toast.makeText(getActivity(), "成功刷新", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
        private void initArticle(final int n) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    String mURL;
                    if (n == 0) {
                        mURL = "https://meiriyiwen.com/";
                        article marticle;
                        jsoupGet jsoupGet1 = new jsoupGet();
                        marticle = jsoupGet1.getArticle(mURL);
                        Message message = new Message();
                        message.what = 1;
                        message.obj = marticle;
                        handler.sendMessage(message);
                    } else {
                        //mURL = "https://meiriyiwen.com/random";
                        article ranArticle = new article();
                        jsoupGet jsoupGet2 = new jsoupGet();
                        ranArticle = jsoupGet2.getRanArticle();
                        Message message = new Message();
                        message.what = 2;
                        message.obj = ranArticle;
                        handler.sendMessage(message);
                    }


                }
            }).start();


        }

    }




