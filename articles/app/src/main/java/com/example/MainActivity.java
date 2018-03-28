package com.example;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;  //对应的viewPager
    private TabLayout tabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        viewPager = (ViewPager) findViewById(R.id.mainvp);
        tabLayout = (TabLayout) findViewById(R.id.maintab);
        fragmentList.add(new articleFragment());
        fragmentList.add(new musicFragment());
        fragmentList.add(new booksFragment());
        viewPager.setAdapter(new FragAdapter(getSupportFragmentManager(), fragmentList));
        tabLayout.setupWithViewPager(viewPager);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent1=new Intent(this,savedArticles.class);
        startActivity(intent1);
        return true;
    }

}






