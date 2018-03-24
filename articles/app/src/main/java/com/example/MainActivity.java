package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;


import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"文章", "音乐", "书架"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();


        viewPager = (ViewPager) findViewById(R.id.vp);
        tabLayout = (TabLayout) findViewById(R.id.maintab);
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
   @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.articles:
                Intent intent2=new Intent(MainActivity.this,articleActivity.class);
                startActivity(intent2);
                break;
            case R.id.music:
                Intent intent3=new Intent(MainActivity.this,musicActivity.class);
                startActivity(intent3);
                break;
            case R.id.books:
                Intent intent4=new Intent(MainActivity.this,booksActivity.class);
                startActivity(intent4);
                break;
        }
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent1=new Intent(this,historicalArticles.class);
        startActivity(intent1);
        return true;
    }


}
