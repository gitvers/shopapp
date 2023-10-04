package com.example.shopapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shopapp.CategoryInnerProduct;
import com.example.shopapp.Models.ViewPagerHomeModel1;
import com.example.shopapp.R;

import java.util.ArrayList;

public class ViewPagerHomeAdapter1 extends RecyclerView.Adapter<ViewPagerHomeAdapter1.ViewHolder> {

    Context context;
    ArrayList<ViewPagerHomeModel1> list;
    ViewPager2 viewPager2;

    public ViewPagerHomeAdapter1(Context context, ArrayList<ViewPagerHomeModel1> list, ViewPager2 viewPager2) {
        this.context = context;
        this.list = list;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewPagerHomeAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home2_viewpager_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHomeAdapter1.ViewHolder holder, int position) {
        ViewPagerHomeModel1 model1 = list.get(position);
        holder.imageView.setImageResource(model1.getImages());


        if (position == list.size() - 2) {
            viewPager2.post(runnable);
        }


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(), CategoryInnerProduct.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_viewpager);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            list.addAll(list);
            notifyDataSetChanged();
        }
    };
}
