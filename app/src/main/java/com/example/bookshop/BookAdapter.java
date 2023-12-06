package com.example.bookshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<BookItem> {

    public BookAdapter(Context context, List<BookItem> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bookitem, parent, false);
        }

        // Get the current book item
        BookItem currentBook = getItem(position);

        // Set the book title
        TextView tvTitle = convertView.findViewById(R.id.bookTitle);
        tvTitle.setText(currentBook.getTitle());

        // Set the book author
        TextView tvAuthor = convertView.findViewById(R.id.bookAuthor);
        tvAuthor.setText(currentBook.getAuthor());

        // Set the book price
        TextView tvPrice = convertView.findViewById(R.id.bookPrice);
        tvPrice.setText(String.valueOf(currentBook.getPrice()));

        // Set the book image
        ImageView ivBookImage = convertView.findViewById(R.id.bookcover);
        // Assuming you have a method to convert byte[] to Bitmap
        ivBookImage.setImageBitmap(BitmapUtils.getBitmapFromByteArray(currentBook.getImagePath()));

        return convertView;
    }
}