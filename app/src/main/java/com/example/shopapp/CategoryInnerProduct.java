package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shopapp.Adapters.Category1Adapter;
import com.example.shopapp.Models.Category1Model;

import java.util.ArrayList;

public class CategoryInnerProduct extends AppCompatActivity {
    RecyclerView recyclerView;
    Category1Adapter adapter;
    ArrayList<Category1Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_inner_product);

        recyclerView = findViewById(R.id.category1_recycler);
        list = new ArrayList<>();
        list.add(new Category1Model(R.drawable.funky, "Funky Pairs", "Multi-colored funky shirt and pants..", "15,000"));
        list.add(new Category1Model(R.drawable.funky, "Denim Pairs", "Multi-colored denim shirt and pants..", "10,000"));
        list.add(new Category1Model(R.drawable.funky, "Licra Pairs", "Multi-colored licra shirt and pants..", "20,000"));
        list.add(new Category1Model(R.drawable.funky, "Allen Solly", "Multi-colored shirt and pants..", "75,000"));
        list.add(new Category1Model(R.drawable.funky, "Gucci", "Multi-colored gucci shirt and pants..", "95,000"));
        list.add(new Category1Model(R.drawable.funky, "Balenciaga ", "Multi-colored shirt and pants..", "115,000"));

        adapter = new Category1Adapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}