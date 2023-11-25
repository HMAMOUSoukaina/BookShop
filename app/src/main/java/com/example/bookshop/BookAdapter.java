package com.example.bookshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.example.bookshop.R;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookshop.BookItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends ArrayAdapter<BookItem> {

    public BookAdapter(Context context, List<BookItem> bookList) {
        super(context, 0, bookList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Récupérer l'élément de données pour cette position
        BookItem bookItem = getItem(position);

        // Vérifier si une vue existante est réutilisée, sinon gonfler la vue
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bookitem, parent, false);
        }

        // Rechercher la vue pour peupler les données
        ImageView ivBookImage = convertView.findViewById(R.id.bookcover);
        TextView tvTitle = convertView.findViewById(R.id.bookTitle);
        TextView tvAuthor = convertView.findViewById(R.id.bookAuthor);
        TextView tvPrice = convertView.findViewById(R.id.bookPrice);

        // Remplir la vue de modèle avec l'objet de données
        Picasso.get().load(bookItem.getImagePath()).into(ivBookImage);
        tvTitle.setText(bookItem.getTitle());
        tvAuthor.setText(bookItem.getAuthor());

        tvPrice.setText(String.valueOf(bookItem.getPrice()));

        // Renvoyer la vue complétée pour l'afficher à l'écran
        return convertView;
    }

}

