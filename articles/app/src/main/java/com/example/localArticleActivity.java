package com.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class localArticleActivity extends AppCompatActivity {

    ListView articleListView;
    List<article> mArticleList1=new ArrayList<>();
    articleAdapter marticleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        articleListView=(ListView)findViewById(R.id.lv_localArticle);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        article thisArticle;
        thisArticle=(article)getIntent().getSerializableExtra("thisArticle");
        mArticleList1.add(thisArticle);
        marticleAdapter = new articleAdapter(localArticleActivity.this, R.layout.article_item, mArticleList1);
        articleListView.setAdapter(marticleAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                localArticleActivity.this.finish();
        }
        return true;
    }
}
