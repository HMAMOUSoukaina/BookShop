package com.example.bookshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ManualDataInsertion {

    public static void insertDummyData(Context context) {
        BooksBDHelper dbHelper = new BooksBDHelper(context);

        // Catégorie : Arts

        addBook(context, dbHelper, "The Art of War", 20, R.drawable.the_art_of_war, "Sun Tzu", "Arts", 19.99);
        addBook(context, dbHelper, "The Last Supper", 14, R.drawable.the_last_supper, "Leonardo da Vinci", "Arts", 13.99);
        addBook(context, dbHelper, "The Birth of Venus", 12, R.drawable.the_birth_of_venus, "Sandro Botticelli", "Arts", 15);
        addBook(context, dbHelper, "The Starry Night", 24, R.drawable.the_starry_night, "Vincent van Gogh", "Arts", 16.50);
        addBook(context, dbHelper, "The Persistence of Memory", 20, R.drawable.the_persistence_of_memory, "Salvador Dalí", "Arts", 17);
        addBook(context, dbHelper, "The Scream", 4, R.drawable.the_scream, "Edvard Munch", "Arts", 14);
        addBook(context, dbHelper, "The Great Wave of Kanagawa", 10, R.drawable.the_great_wave_of_kanagawa, "Hokusai", "Arts", 14);
        addBook(context, dbHelper, "The Night Cafe", 10, R.drawable.the_night_cafe, "Vincent van Gogh", "Arts", 14);
    }

    private static void addBook(Context context, BooksBDHelper dbHelper, String title, int quantity, int imageResource, String author, String category, double price) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageResource);
        byte[] imageBytes = convertBitmapToByteArray(bitmap);
        dbHelper.addBook(new BookItem(title, quantity, imageBytes, author, category, price));
    }

    // Méthode utilitaire pour convertir un Bitmap en tableau de bytes
    private static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
