package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class savedArticles extends AppCompatActivity {

    List<article> savedArticleList=new ArrayList<>();
    ListView savedArticle;
    savedArticlesAdapter savedArticleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedarticles);
        savedArticle=(ListView)findViewById(R.id.lv_savedarticles);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        initArticles();
        savedArticleAdapter=new savedArticlesAdapter(this, R.layout.savedarticles_item, savedArticleList);
        savedArticle.setAdapter(savedArticleAdapter);
    }
    private void initArticles() {
        savedArticleList.clear();
        savedArticleList= DataSupport.findAll(article.class);
    }
}
