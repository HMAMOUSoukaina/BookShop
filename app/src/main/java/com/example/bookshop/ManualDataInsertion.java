package com.example.bookshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ManualDataInsertion {

    public static void insertDummyData(Context context) {
        BooksBDHelper dbHelper = new BooksBDHelper(context);

        // Catégorie : Arts

        addBook(context, dbHelper, 1,"The Art of War", 20, R.drawable.the_art_of_war, "Sun Tzu", "Arts", 19.99,"desc");
        addBook(context, dbHelper,2, "The Last Supper", 14, R.drawable.the_last_supper, "Leonardo da Vinci", "Arts", 13.99,"desc");
        addBook(context, dbHelper,3, "The Birth of Venus", 12, R.drawable.the_birth_of_venus, "Sandro Botticelli", "Arts", 15,"desc");
        addBook(context, dbHelper,4, "The Starry Night", 24, R.drawable.the_starry_night, "Vincent van Gogh", "Arts", 16.50,"desc");
        addBook(context, dbHelper, 5,"The Persistence of Memory", 20, R.drawable.the_persistence_of_memory, "Salvador Dalí", "Arts", 17,"desc");
        addBook(context, dbHelper,6, "The Scream", 4, R.drawable.the_scream, "Edvard Munch", "Arts", 14,"desc");
        addBook(context, dbHelper,7, "The Great Wave of Kanagawa", 10, R.drawable.the_great_wave_of_kanagawa, "Hokusai", "Arts", 14,"desc");
        addBook(context, dbHelper, 8,"The Night Cafe", 10, R.drawable.the_night_cafe, "Vincent van Gogh", "Arts", 14,"desc");


        // Catégorie : History

        addBook(context, dbHelper, 9,"The Guns of August", 12, R.drawable.the_guns_of_august, "Friedrich von Bernhardi", "History", 14,"desc");
        addBook(context, dbHelper,10, "The Rise and Fall of the Third Reich", 22, R.drawable.the_rise_and_fall_of_the_third_reich, "William L. Shirer", "History", 19,"desc");
        addBook(context, dbHelper,11, "The Time of the Revolutions", 12, R.drawable.the_time_of_the_revolutions, "Daniel de Montplaisir", "History", 15,"desc");
        addBook(context, dbHelper,12, "In the Shadow of Empires", 24, R.drawable.in_the_shadow_of_empires, "Germain Payen", "History", 16.50,"desc");
        addBook(context, dbHelper, 13,"The Age of Persia", 20, R.drawable.the_age_of_persia, "Yves Bomati", "History", 17,"desc");
        addBook(context, dbHelper,14, "Une autre histoire de la Renaissance", 4, R.drawable.une_autre_histoire_de_la_renaissance, "Didier Le Fur", "History", 14,"desc");
        addBook(context, dbHelper,15, "The Embracing of the World", 10, R.drawable.the_embracing_of_the_world, "Victor Court", "History", 11.99,"desc");
        addBook(context, dbHelper, 16,"The Scepter and the Pen", 10, R.drawable.the_scepter_and_the_pen, "Bruno de Cessole", "History", 15,"desc");
    }

    private static void addBook(Context context, BooksBDHelper dbHelper, int id,String title, int quantity, int imageResource, String author, String category, double price,String description) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageResource);
        byte[] imageBytes = convertBitmapToByteArray(bitmap);
        dbHelper.addBook(new BookItem(id,title, quantity, imageBytes, author, category, price,description));
    }

    // Méthode utilitaire pour convertir un Bitmap en tableau de bytes
    private static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
