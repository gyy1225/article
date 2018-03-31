package com.example;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class menuContentActivity extends AppCompatActivity {

    TextView chapterTextView,contentTextView;
    article chapter;
    String chapterURL;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    article mChapter=(article)msg.obj;
                    String content=mChapter.getText();
                    contentTextView.setText(content);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        menu menu1=(menu)getIntent().getSerializableExtra("thisMenu");
        chapterURL=menu1.getChapterURL();
        initMenus();
        chapterTextView=(TextView)findViewById(R.id.tv_chapter2);
        chapterTextView.setText(menu1.getMenu());
        contentTextView=(TextView)findViewById(R.id.tv_content2);
    }
    private void initMenus() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                article mchapter=getChapter(chapterURL);
                Message message = new Message();
                message.what = 1;
                message.obj = mchapter;
                handler.sendMessage(message);
            }


        }).start();
    }

    public article getChapter(String chapterURL) {
        String content=" ";
        article mchapter=new article();
        try {
            Document document1 = (Document) Jsoup.connect(chapterURL).get();
            Elements contents=document1.getElementsByClass("articleContent").select("p");
            for (int i=0;i<contents.size();i++) {
                content =  content + "        "+ contents.get(i).text()+"\n"+"\n";
            }
            mchapter.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mchapter;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                menuContentActivity.this.finish();
        }
        return true;
    }

}
