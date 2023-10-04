package com.example.shopapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.Models.NewFragRecyclerModel;
import com.example.shopapp.R;

import java.util.ArrayList;

public class NewFragRecyclerAdapter extends RecyclerView.Adapter<NewFragRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<NewFragRecyclerModel> list;

    public NewFragRecyclerAdapter(Context context, ArrayList<NewFragRecyclerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewFragRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_frag_recycler_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewFragRecyclerAdapter.ViewHolder holder, int position) {
        NewFragRecyclerModel model = list.get(position);
        holder.CategoryName.setText(model.getName());

        holder.adapter = new NewFragInnerRecyclerAdapter(context, model.getList());
        holder.recyclerView.setAdapter(holder.adapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView CategoryName, viewall;
        RecyclerView recyclerView;
        NewFragInnerRecyclerAdapter adapter;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            CategoryName = itemView.findViewById(R.id.category_txt);
            viewall = itemView.findViewById(R.id.viewall_txt);
            recyclerView = itemView.findViewById(R.id.newFragRecycler);
        }
    }
}
