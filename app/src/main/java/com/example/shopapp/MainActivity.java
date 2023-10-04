package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.shopapp.Fragments.HomeFragment;
import com.example.shopapp.Fragments.ProfileFragment;
import com.example.shopapp.Fragments.SearchFragment;
import com.example.shopapp.Fragments.WishlistFragment;
import com.example.shopapp.SubFragments.Home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements Home.ScrollListener {

    BottomNavigationView bottomNavigationView;


    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.botton_nav);
        frameLayout = findViewById(R.id.frame);
        setFragment(new HomeFragment());


        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                setFragment(new HomeFragment());
                return true;

            } else if (item.getItemId() == R.id.search) {
                setFragment(new SearchFragment());
                return true;

            } else if (item.getItemId() == R.id.favourite) {
                setFragment(new WishlistFragment());
                return true;

            } else if (item.getItemId() == R.id.profile) {
                setFragment(new ProfileFragment());
                return true;

            } else {
                return false;
            }
        });


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onRecyclerViewScrolled(boolean isScrollingUp) {
        if (isScrollingUp) {
            bottomNavigationView.animate().translationY(bottomNavigationView.getHeight())
                    .setDuration(200)
                    .withEndAction(() ->
                            bottomNavigationView.setVisibility(View.GONE));

        } else {
            bottomNavigationView.animate().translationY(0).setDuration(150);
            bottomNavigationView.setVisibility(View.VISIBLE);

        }
    }


}