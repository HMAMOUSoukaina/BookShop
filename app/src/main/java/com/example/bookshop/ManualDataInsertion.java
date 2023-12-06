package com.example.bookshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ManualDataInsertion {

    public static void insertDummyData(Context context) {
        BooksBDHelper dbHelper = new BooksBDHelper(context);

        // Catégorie : Arts

        addBook(context, dbHelper, 1,"The Art of War", 20, R.drawable.the_art_of_war, "Sun Tzu", "Arts", 19.99);
        addBook(context, dbHelper,2, "The Last Supper", 14, R.drawable.the_last_supper, "Leonardo da Vinci", "Arts", 13.99);
        addBook(context, dbHelper,3, "The Birth of Venus", 12, R.drawable.the_birth_of_venus, "Sandro Botticelli", "Arts", 15);
        addBook(context, dbHelper,4, "The Starry Night", 24, R.drawable.the_starry_night, "Vincent van Gogh", "Arts", 16.50);
        addBook(context, dbHelper, 5,"The Persistence of Memory", 20, R.drawable.the_persistence_of_memory, "Salvador Dalí", "Arts", 17);
        addBook(context, dbHelper,6, "The Scream", 4, R.drawable.the_scream, "Edvard Munch", "Arts", 14);
        addBook(context, dbHelper,7, "The Great Wave of Kanagawa", 10, R.drawable.the_great_wave_of_kanagawa, "Hokusai", "Arts", 14);
        addBook(context, dbHelper, 8,"The Night Cafe", 10, R.drawable.the_night_cafe, "Vincent van Gogh", "Arts", 14);
     // Catégorie : History

        addBook(context, dbHelper, 9,"The Guns of August", 12, R.drawable.the_guns_of_august, "Friedrich von Bernhardi", "History", 14);
        addBook(context, dbHelper,10, "The Rise and Fall of the Third Reich", 22, R.drawable.the_rise_and_fall_of_the_third_reich, "William L. Shirer", "History", 19);
        addBook(context, dbHelper,11, "The Time of the Revolutions", 12, R.drawable.the_time_of_the_revolutions, "Daniel de Montplaisir", "History", 15);
        addBook(context, dbHelper,12, "In the Shadow of Empires", 24, R.drawable.in_the_shadow_of_empires, "Germain Payen", "History", 16.50);
        addBook(context, dbHelper, 13,"The Age of Persia", 20, R.drawable.the_age_of_persia, "Yves Bomati", "History", 17);
        addBook(context, dbHelper,14, "Une autre histoire de la Renaissance", 4, R.drawable.une_autre_histoire_de_la_renaissance, "Didier Le Fur", "History", 14);
        addBook(context, dbHelper,15, "The Embracing of the World", 10, R.drawable.the_embracing_of_the_world, "Victor Court", "History", 11.99);
        addBook(context, dbHelper, 16,"The Scepter and the Pen", 10, R.drawable.the_scepter_and_the_pen, "Bruno de Cessole", "History", 15);

        // Catégorie : Literature

        addBook(context, dbHelper, 17,"To Kill a Mockingbird", 9, R.drawable.to_kill_a_mockingbird, "Harper Lee", "Literature", 14);
        addBook(context, dbHelper,18, "1984", 22, R.drawable.b1984, "George Orwell", "Literature", 19);
        addBook(context, dbHelper,19, "The Great Gatsby", 20, R.drawable.the_great_gatsby, "F. Scott Fitzgerald", "Literature", 15);
        addBook(context, dbHelper,20, "The Catcher in the Rye", 10, R.drawable.the_catcher_in_the_rye, "J.D. Salinger", "Literature", 16.50);
        addBook(context, dbHelper, 21,"Pride and Prejudice", 20, R.drawable.pride_and_prejudice, "Jane Austen", "Literature", 17);
        addBook(context, dbHelper, 22,"The Lord of the Rings", 21, R.drawable.the_lord_of_the_rings, "J.R.R. Tolkien", "Literature", 22);
        addBook(context, dbHelper, 23,"Crime and Punishment", 22, R.drawable.crime_and_punishment, "Fyodor Dostoevsky", "Literature", 10.95);
        addBook(context, dbHelper, 24,"The Hobbit", 22, R.drawable.the_hobbit, "J.R.R. Tolkien", "Literature", 13.99);


        //Catégorie : Philosophy
        addBook(context, dbHelper, 25,"Meditations", 9, R.drawable.meditations, "Marcus Aurelius", "Philosophy", 14);
        addBook(context, dbHelper,26, "The Republic", 22, R.drawable.the_republic, "Plato", "Philosophy", 19);
        addBook(context, dbHelper,27, "The Significance of the New Logic", 20, R.drawable.the_significance_of_the_new_logic, "Willard Van Orman Quine", "Philosophy", 15);
        addBook(context, dbHelper,28, "The Vices of Knowledge", 10, R.drawable.the_vices_of_knowledge, "Pascal Engel", "Philosophy", 16.50);
        addBook(context, dbHelper, 29,"The Courage to Think the Future", 20, R.drawable.the_courage_to_think_the_future, "Christoph Theobald", "Philosophy", 17);
        addBook(context, dbHelper, 30,"Reduced to Nothing", 21, R.drawable.reduced_to_nothing, "Rémy Valléjo", "Philosophy", 22);


        //Catégorie Science


        addBook(context, dbHelper, 25,"A Brief History of Time", 40, R.drawable.a_brief_history_of_time, "Stephen Hawking", "Science", 30);
        addBook(context, dbHelper,26, "The Selfish Gene", 28, R.drawable.the_selfish_gene, "Richard Dawkins", "Science ", 25);
        addBook(context, dbHelper,27, "The Embracing of the World", 30, R.drawable.the_embracing_of_the_world, "Victor Court", "Science", 20);



        //Catégorie Religion
        addBook(context,dbHelper,28,"Le courage de penser l’avenir",12,R.drawable.le_courage_de_penser_lavenir,"Christoph Theobald","Religion",12);
        addBook(context,dbHelper,29,"Réduit à rien",12,R.drawable.reduit_a_rien,"Rémy Valléjo","Religion",20);
        addBook(context,dbHelper,30,"The Hobbit",12,R.drawable.the_hobbit,"J.R.R. Tolkien","Religion",12);
    }



    private static void addBook(Context context, BooksBDHelper dbHelper, int id,String title, int quantity, int imageResource, String author, String category, double price) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageResource);
        byte[] imageBytes = convertBitmapToByteArray(bitmap);
        dbHelper.addBook(new BookItem(id,title, quantity, imageBytes, author, category, price));
    }

    // Méthode utilitaire pour convertir un Bitmap en tableau de bytes
    private static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}