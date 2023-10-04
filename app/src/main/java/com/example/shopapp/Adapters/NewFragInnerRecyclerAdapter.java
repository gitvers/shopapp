package com.example.shopapp.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.Models.NewFragInnerRecyclerModel;
import com.example.shopapp.R;

import java.util.ArrayList;

public class NewFragInnerRecyclerAdapter extends RecyclerView.Adapter<NewFragInnerRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<NewFragInnerRecyclerModel> list;

    public NewFragInnerRecyclerAdapter(Context context, ArrayList<NewFragInnerRecyclerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewFragInnerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.new_frag_inner_recycle_style,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewFragInnerRecyclerAdapter.ViewHolder holder, int position) {
        NewFragInnerRecyclerModel model = list.get(position);
        holder.productImage.setImageResource(model.getImages());
        holder.desTxt.setText(model.getDescription());
        holder.priceTxt.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView desTxt,priceTxt;
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            desTxt = itemView.findViewById(R.id.newFrag_prodt_desc);
            priceTxt = itemView.findViewById(R.id.newFrag_prodt_price);
            productImage = itemView.findViewById(R.id.new_frag_prodimg);

        }
    }
}
