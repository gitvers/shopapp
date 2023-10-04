package com.example.shopapp.Adapters;

import android.app.FragmentTransaction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.shopapp.SubFragments.Home;
import com.example.shopapp.SubFragments.New;
import com.example.shopapp.SubFragments.Sale;
import com.example.shopapp.SubFragments.Trending;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final Home homefragment;
    private final New newfragment;
    private final Trending trendingfragment;
    private final Sale salefragment;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        homefragment = new Home();
        newfragment = new New();
        trendingfragment = new Trending();
        salefragment = new Sale();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return homefragment;
        } else if (position == 1) {
            return newfragment;
        } else if (position == 2) {
            return trendingfragment;
        } else {
            return salefragment;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Home";
        } else if (position == 1) {
            return "New";
        } else if (position == 2) {
            return "Trending";
        } else {
            return "Sale";
        }
    }
}
