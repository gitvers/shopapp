package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.shopapp.Adapters.DesViewPagerAdapter;
import com.example.shopapp.Adapters.ProdRecyclerAdapter;
import com.example.shopapp.Adapters.ProdRecyclerAdapter2;
import com.example.shopapp.Models.ProdRecyclerModel;
import com.example.shopapp.Models.ProdRecyclerModel2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ProductDescription extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    RecyclerView recyclerView, recyclerView2;
    ArrayList<ProdRecyclerModel> list;
    ArrayList<ProdRecyclerModel2> list2;
    ProdRecyclerAdapter adapter;
    ProdRecyclerAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        list = new ArrayList<>();
        list2 = new ArrayList<>();

        viewPager = findViewById(R.id.prod_viewpager2);
        tabLayout = findViewById(R.id.prod_tab_layout);
        recyclerView = findViewById(R.id.prod_recyclerview);
        recyclerView2 = findViewById(R.id.prod_recyclerview2);


        DesViewPagerAdapter desViewPagerAdapter = new DesViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(desViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        list.add(new ProdRecyclerModel(R.drawable.classic, "Denims", "Denim is a type of woven twill fabric."));
        list.add(new ProdRecyclerModel(R.drawable.classic, "Denims", "Denim is a type of woven twill fabric."));
        list.add(new ProdRecyclerModel(R.drawable.classic, "Denims", "Denim is a type of woven twill fabric."));
        list.add(new ProdRecyclerModel(R.drawable.classic, "Denims", "Denim is a type of woven twill fabric."));
        list.add(new ProdRecyclerModel(R.drawable.classic, "Denims", "Denim is a type of woven twill fabric."));
        list.add(new ProdRecyclerModel(R.drawable.classic, "Denims", "Denim is a type of woven twill fabric."));

        list2.add(new ProdRecyclerModel2(R.drawable.newcollection, "Denims", "Denim is a type of woven twill fabric."));
        list2.add(new ProdRecyclerModel2(R.drawable.newcollection, "Denims", "Denim is a type of woven twill fabric."));
        list2.add(new ProdRecyclerModel2(R.drawable.newcollection, "Denims", "Denim is a type of woven twill fabric."));
        list2.add(new ProdRecyclerModel2(R.drawable.newcollection, "Denims", "Denim is a type of woven twill fabric."));
        list2.add(new ProdRecyclerModel2(R.drawable.newcollection, "Denims", "Denim is a type of woven twill fabric."));
        list2.add(new ProdRecyclerModel2(R.drawable.newcollection, "Denims", "Denim is a type of woven twill fabric."));

        adapter = new ProdRecyclerAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter2 = new ProdRecyclerAdapter2(this, list2);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }


}