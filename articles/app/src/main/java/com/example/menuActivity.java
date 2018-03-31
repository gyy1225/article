package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class menuActivity extends AppCompatActivity {

    List<menu> mMenuList1;
    menuAdapter menuAdapter;
    ListView menuListview;
    ImageView menuImageView;
    TextView authorTextView, titleTextView;
    String mMenuURL;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mMenuList1 = (List<menu>) msg.obj;
                    menuAdapter = new menuAdapter(menuActivity.this, R.layout.menu_item, mMenuList1);
                    menuListview.setAdapter(menuAdapter);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        menuListview = (ListView) findViewById(R.id.lv_bookMenu);
        menuListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menu menu = mMenuList1.get(position);
                Intent intent8 = new Intent(menuActivity.this, menuContentActivity.class);
                intent8.putExtra("thisMenu",menu);
                startActivity(intent8);
            }

        });

        menuImageView = (ImageView) findViewById(R.id.book_image2);
        titleTextView = (TextView) findViewById(R.id.book_title2);
        authorTextView = (TextView) findViewById(R.id.book_author2);
        book book1 = (book) getIntent().getSerializableExtra("thisBook");
        mMenuURL = book1.getMenuURL();
        String author = book1.getAuthor();
        String title = book1.getTitle();
        titleTextView.setText(title);
        authorTextView.setText(author);
        Glide.with(menuActivity.this).load(book1.getImageURL()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(menuImageView);

        initMenus();
    }

    private void initMenus() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<menu> mMenuList = new ArrayList<>();
                mMenuList = getMenus(mMenuURL);
                Message message = new Message();
                message.what = 1;
                message.obj = mMenuList;
                handler.sendMessage(message);
            }


        }).start();
    }

    public List<menu> getMenus(String menuURL) {
        String menu, imageURL;
        Document document;
        List<menu> menuList1 = new ArrayList<>();

        try {
            Document document1 = (Document) Jsoup.connect(menuURL).get();
            Elements menuElements = document1.getElementsByClass("chapter-list").select("a");
            for (int j = 0; j < menuElements.size(); j++) {
                menu menu1 = new menu();
                Element menuElement1 = menuElements.get(j);
                String chapterElement="http://book.meiriyiwen.com"+ menuElement1.select("a").attr("href");
                String mMenu1 = menuElement1.text();
                Log.e(mMenu1, mMenu1);
                menu1.setMenu(mMenu1);
                menu1.setChapterURL(chapterElement);
                menuList1.add(menu1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menuList1;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                menuActivity.this.finish();
        }
        return true;
    }
}
