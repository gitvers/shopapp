package com.example.shopapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.shopapp.SubFragments.AboutFragment;
import com.example.shopapp.SubFragments.DescriptionFragment;
import com.example.shopapp.SubFragments.Home;
import com.example.shopapp.SubFragments.New;

public class DesViewPagerAdapter extends FragmentPagerAdapter {

    private final DescriptionFragment descriptionFragment;
    private final AboutFragment aboutFragment;

    public DesViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        descriptionFragment = new DescriptionFragment();
        aboutFragment = new AboutFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return descriptionFragment;
        } else {
            return aboutFragment;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Description";
        } else {
            return "About Us";
        }
    }
}
