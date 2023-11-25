package com.example.bookshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CartAdapter  {
    //extends ArrayAdapter<BookItem>

    /*

    private Context context;
    private List<BookItem> books;

    public CartAdapter(Context context, List<BookItem> books) {
        super(context, R.layout.list_cart, books);
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_cart, parent, false);

        TextView titleTextView = rowView.findViewById(R.id.itemTitle);
        TextView quantityTextView = rowView.findViewById(R.id.itemQuantity);
        ImageView bookImageView = rowView.findViewById(R.id.itemImage);
        CheckBox checkBox = rowView.findViewById(R.id.checkBox);
        ImageView deleteIcon = rowView.findViewById(R.id.deleteIcon);

        BookItem currentItem = getItem(position);

        titleTextView.setText(currentItem.getTitle());
        quantityTextView.setText(String.valueOf(currentItem.getQuantity()));
        bookImageView.setImageResource(currentItem.getImagePath());

        // Set long click listener to show the CheckBox and delete icon
        rowView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                checkBox.setVisibility(View.VISIBLE);
                deleteIcon.setVisibility(View.VISIBLE);
                return true; // Consume the long click event
            }
        });

        // Set click listener for delete icon to delete the item
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete the item from the list
                remove(currentItem);
                notifyDataSetChanged();
            }
        });

        // Set click listener for CheckBox to handle additional logic if needed
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle CheckBox state change if needed
        });

        return rowView;
    }

    */

}