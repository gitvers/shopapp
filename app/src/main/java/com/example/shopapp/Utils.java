package com.example.shopapp;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public void message(Context context) {
        Toast.makeText(context, "Got Method", Toast.LENGTH_SHORT).show();
    }
}
