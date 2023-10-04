package com.example.shopapp.Models;

import java.util.ArrayList;

public class NewFragRecyclerModel {
    String name;
    ArrayList<NewFragInnerRecyclerModel> list;

    public NewFragRecyclerModel(String name, ArrayList<NewFragInnerRecyclerModel> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NewFragInnerRecyclerModel> getList() {
        return list;
    }

    public void setList(ArrayList<NewFragInnerRecyclerModel> list) {
        this.list = list;
    }
}
