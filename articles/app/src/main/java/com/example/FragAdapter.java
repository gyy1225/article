package com.example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ASUS on 2018/3/25.
 */

public class FragAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

        private List<Fragment> fragmentList;
        private String titles[] = {"文章","声音","书架",};

        public FragAdapter(FragmentManager fm ,List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


