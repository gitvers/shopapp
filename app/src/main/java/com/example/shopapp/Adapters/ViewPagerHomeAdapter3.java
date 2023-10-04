package com.example.shopapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shopapp.Models.ViewPagerHomeModel3;
import com.example.shopapp.R;

import java.util.ArrayList;

public class ViewPagerHomeAdapter3 extends RecyclerView.Adapter<ViewPagerHomeAdapter3.ViewHolder> {

    Context context;
    ArrayList<ViewPagerHomeModel3> list;
    ViewPager2 viewPager2;

    public ViewPagerHomeAdapter3(Context context, ArrayList<ViewPagerHomeModel3> list, ViewPager2 viewPager2) {
        this.context = context;
        this.list = list;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewPagerHomeAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home2_viewpager_style, parent, false);
        return new ViewPagerHomeAdapter3.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHomeAdapter3.ViewHolder holder, int position) {
        ViewPagerHomeModel3 model3 = list.get(position);
        holder.image.setImageResource(model3.getImages());

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

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            list.addAll(list);
            notifyDataSetChanged();
        }
    };
}
