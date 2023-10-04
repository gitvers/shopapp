package com.example.shopapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.Models.Category1Model;
import com.example.shopapp.ProductDescription;
import com.example.shopapp.R;

import java.util.ArrayList;

public class Category1Adapter extends RecyclerView.Adapter<Category1Adapter.ViewHolder> {

    Context context;
    ArrayList<Category1Model> list;
    int temp;

    public Category1Adapter(Context context, ArrayList<Category1Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Category1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categorylist_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Category1Adapter.ViewHolder holder, int position) {
        Category1Model model = list.get(position);
        holder.imageView.setImageResource(model.getImages());
        holder.prodName.setText(model.getName());
        holder.prodDesc.setText(model.getDescription());
        holder.prodPrice.setText(model.getPrice());

        holder.like.setOnClickListener(view -> {
            if (temp == 0) {
                holder.like.setImageResource(R.drawable.favheart2);
                temp++;
            } else {
                holder.like.setImageResource(R.drawable.favheart);
                temp--;
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProductDescription.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, like;
        TextView prodName, prodDesc, prodPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.new_frag_prodimg);
            like = itemView.findViewById(R.id.like_img);
            prodName = itemView.findViewById(R.id.prodt_name);
            prodDesc = itemView.findViewById(R.id.newFrag_prodt_desc);
            prodPrice = itemView.findViewById(R.id.price);

        }
    }
}
