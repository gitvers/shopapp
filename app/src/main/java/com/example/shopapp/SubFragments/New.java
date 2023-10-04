package com.example.shopapp.SubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopapp.Adapters.NewFragRecyclerAdapter;
import com.example.shopapp.Models.NewFragInnerRecyclerModel;
import com.example.shopapp.Models.NewFragRecyclerModel;
import com.example.shopapp.R;

import java.util.ArrayList;


public class New extends Fragment {
    RecyclerView recyclerView;
    NewFragRecyclerAdapter adapter;
    ArrayList<NewFragRecyclerModel> parentlist;
    ArrayList<NewFragInnerRecyclerModel> childlist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container, false);

        parentlist = new ArrayList<>();
        childlist = new ArrayList<>();

        recyclerView = view.findViewById(R.id.new_frag_recycler);

        childlist.add(new NewFragInnerRecyclerModel("Denim is a type of woven twill fabric.","12000",R.drawable.classic));
        childlist.add(new NewFragInnerRecyclerModel("Denim is a type of woven twill fabric.","12000",R.drawable.classic));
        childlist.add(new NewFragInnerRecyclerModel("Denim is a type of woven twill fabric.","12000",R.drawable.classic));
        childlist.add(new NewFragInnerRecyclerModel("Denim is a type of woven twill fabric.","12000",R.drawable.classic));
        childlist.add(new NewFragInnerRecyclerModel("Denim is a type of woven twill fabric.","12000",R.drawable.classic));

        parentlist.add(new NewFragRecyclerModel("Denim",childlist));
        parentlist.add(new NewFragRecyclerModel("Gucci",childlist));
        parentlist.add(new NewFragRecyclerModel("Balanciaga",childlist));
        parentlist.add(new NewFragRecyclerModel("Allen Solley",childlist));
        parentlist.add(new NewFragRecyclerModel("USPA",childlist));

        adapter = new NewFragRecyclerAdapter(getContext(),parentlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}