package com.example.shopapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.Models.BannerModel;
import com.example.shopapp.R;

import java.util.ArrayList;

public class BannerPagerAdapter extends RecyclerView.Adapter<BannerPagerAdapter.ViewHolder> {

    Context context;
    ArrayList<BannerModel> list;

    public BannerPagerAdapter(Context context, ArrayList<BannerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BannerPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.slider_banner_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerPagerAdapter.ViewHolder holder, int position) {
        BannerModel model = list.get(position);
        int image = model.getImages();

        holder.imageView.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.banner_image);
        }
    }

}
