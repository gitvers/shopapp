package com.example.shopapp.Fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shopapp.Adapters.ViewPagerAdapter;
import com.example.shopapp.CustomViewPager;
import com.example.shopapp.R;
import com.example.shopapp.SubFragments.Home;
import com.google.android.material.tabs.TabLayout;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class HomeFragment extends Fragment implements Home.ScrollListener {

    //ViewPager viewPager;
    TabLayout tabLayout;
    ImageView img;
    CustomViewPager customViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.white));
        }

        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        img = view.findViewById(R.id.whatsapp_btn);
        customViewPager = view.findViewById(R.id.view_pager);

        img.setOnClickListener(view1 -> {

            String contact = "+91 7984247805"; // use country code with your phone number
            String url = null;
            try {
                url = "https://api.whatsapp.com/send?phone=" + contact + "&text=" + URLEncoder.encode("Hey,I want to shop at ShopVilla", "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                PackageManager pm = getContext().getPackageManager();
                pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(getContext(), "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        customViewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(customViewPager);
        customViewPager.setSwipeEnabled(false);
        return view;

    }

    @Override
    public void onRecyclerViewScrolled(boolean isScrollingUp) {
        if (isScrollingUp) {
            tabLayout.setVisibility(View.GONE);
        } else {
            tabLayout.setVisibility(View.VISIBLE);
        }
    }

}