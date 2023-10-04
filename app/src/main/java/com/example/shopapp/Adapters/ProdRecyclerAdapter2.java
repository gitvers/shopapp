package com.example.shopapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.Models.ProdRecyclerModel2;
import com.example.shopapp.R;

import java.util.ArrayList;

public class ProdRecyclerAdapter2 extends RecyclerView.Adapter<ProdRecyclerAdapter2.ViewHolder> {

    Context context;
    ArrayList<ProdRecyclerModel2> list;

    public ProdRecyclerAdapter2(Context context, ArrayList<ProdRecyclerModel2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProdRecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.prod_recycler_style, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProdRecyclerAdapter2.ViewHolder holder, int position) {
        ProdRecyclerModel2 model2 = list.get(position);
        holder.img.setImageResource(model2.getImages());
        holder.txt1.setText(model2.getName());
        holder.txt2.setText(model2.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt1, txt2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.new_frag_prodimg);
            txt1 = itemView.findViewById(R.id.prodt_name);
            txt2 = itemView.findViewById(R.id.newFrag_prodt_desc);
        }
    }
}
