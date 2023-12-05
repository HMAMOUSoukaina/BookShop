package com.example.bookshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ManualDataInsertion {

    public static void insertDummyData(Context context) {
        BooksBDHelper dbHelper = new BooksBDHelper(context);

        // Catégorie : Arts

        // Récupérez l'image depuis les ressources drawable
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bookcover);

        // Convertissez l'image en tableau de bytes
        byte[] imageBytes = convertBitmapToByteArray(bitmap);

        // Créez un nouveau BookItem
        dbHelper.addBook(new BookItem("Titre du livre", 1, imageBytes, "Auteur", "Catégorie", 19.99));




    }

    // Méthode utilitaire pour convertir un Bitmap en tableau de bytes
    private static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
