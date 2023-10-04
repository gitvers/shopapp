package com.example.shopapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shopapp.Models.ViewPagerHomeModel2;
import com.example.shopapp.R;

import java.util.ArrayList;

public class ViewPagerHomeAdapter2 extends RecyclerView.Adapter<ViewPagerHomeAdapter2.ViewHolder> {

    Context context;
    ArrayList<ViewPagerHomeModel2> list;
    ViewPager2 viewPager2;

    public ViewPagerHomeAdapter2(Context context, ArrayList<ViewPagerHomeModel2> list, ViewPager2 viewPager2) {
        this.context = context;
        this.list = list;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewPagerHomeAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home2_viewpager_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHomeAdapter2.ViewHolder holder, int position) {
        ViewPagerHomeModel2 model2 = list.get(position);
        holder.image.setImageResource(model2.getImages());

        if (position == list.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_viewpager);
        }
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            list.addAll(list);
            notifyDataSetChanged();
        }
    };
}
