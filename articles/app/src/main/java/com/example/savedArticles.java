package com.example;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class savedArticles extends AppCompatActivity {
    article delArticle;
    List<article> savedArticleList = new ArrayList<>();
    ListView savedArticle;
    savedArticlesAdapter savedArticleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedarticles);
        savedArticle = (ListView) findViewById(R.id.lv_savedarticles);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initArticles();
        savedArticleAdapter = new savedArticlesAdapter(this, R.layout.savedarticles_item, savedArticleList);
        savedArticle.setAdapter(savedArticleAdapter);
        savedArticle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                article marticle = savedArticleList.get(position);
                Intent intent6 = new Intent(savedArticles.this, localArticleActivity.class);
                intent6.putExtra("thisArticle", marticle);
                startActivity(intent6);
            }
        });
        savedArticle.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                 delArticle=savedArticleList.get(position);
                AlertDialog.Builder dialog=new AlertDialog.Builder(savedArticles.this);
                dialog.setTitle("确认删除这篇文章吗？");
                dialog.setMessage("删除:"+delArticle.getTitle());
                dialog.setCancelable(true);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        savedArticleList.remove(delArticle);
                        DataSupport.deleteAll(article.class,"title = ? ",delArticle.getTitle());
                        savedArticleAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        savedArticles.this.finish();
                    }
                });
                dialog.show();
                return false;
            }

            });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               savedArticles.this.finish();
        }
        return true;
    }
    private void initArticles() {
        savedArticleList.clear();
        savedArticleList = DataSupport.findAll(article.class);
    }
}
