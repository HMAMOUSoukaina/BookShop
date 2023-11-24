package com.example.bookshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter<BookItem> {
    private Context ct;
    private ArrayList<BookItem> arr;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<BookItem> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
convertView = i.inflate(R.layout.bookitem,null);
        }
        if(arr.size() > 0){
            BookItem b = arr.get(position);

        }
        return convertView;
    }
}

