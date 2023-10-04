package com.example.shopapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.Models.ProdRecyclerModel;
import com.example.shopapp.R;

import java.util.List;

public class ProdRecyclerAdapter extends RecyclerView.Adapter<ProdRecyclerAdapter.ViewHolder> {

    Context context;
    List<ProdRecyclerModel> list;

    public ProdRecyclerAdapter(Context context, List<ProdRecyclerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProdRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.prod_recycler_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdRecyclerAdapter.ViewHolder holder, int position) {
        ProdRecyclerModel model = list.get(position);
        holder.imageView.setImageResource(model.getImages());
        holder.name.setText(model.getName());
        holder.description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.new_frag_prodimg);
            name = itemView.findViewById(R.id.prodt_name);
            description = itemView.findViewById(R.id.newFrag_prodt_desc);
        }
    }
}
