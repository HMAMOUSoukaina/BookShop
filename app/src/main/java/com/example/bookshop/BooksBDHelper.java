package com.example.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bookshop.BookItem;

import java.util.ArrayList;
import java.util.List;

public class BooksBDHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mybooks.db";
    private static final int DATABASE_VERSION = 2;




    public static final String COLUMN_PRICE = "Price";

    public static final String COLUMN_DESCRIPTION ="description";
    public static final String TABLE_BOOKS = "books";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_IMAGE_PATH = "image_path";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_BOOKS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_QUANTITY + " INTEGER, " +
                    COLUMN_AUTHOR + " TEXT, " +
                    COLUMN_CATEGORY + " TEXT, " +
                    COLUMN_PRICE + " REAL, " +
                    COLUMN_IMAGE_PATH + " BLOB," +
                    COLUMN_DESCRIPTION + " TEXT)";


    public BooksBDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }

    // Méthode pour ajouter un livre à la base de données
    public long addBook(BookItem book) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, book.getTitle());
        values.put(COLUMN_QUANTITY, book.getQuantity());
        values.put(COLUMN_AUTHOR, book.getAuthor());
        values.put(COLUMN_CATEGORY, book.getCategory());
        values.put(COLUMN_IMAGE_PATH, book.getImagePath());
        values.put(COLUMN_PRICE, book.getPrice());
        values.put(COLUMN_DESCRIPTION,book.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;

        try {
            result = db.insert(TABLE_BOOKS, null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return result;
    }

    // Méthode pour récupérer les livres d'une catégorie spécifique
    public List<BookItem> getBooksByCategory(String category) {
        List<BookItem> books = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(
                    TABLE_BOOKS,
                    null,
                    COLUMN_CATEGORY + "=?",
                    new String[]{category},
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                    int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTITY));
                    int id=cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                    String author = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTHOR));
                    String cat = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY));
                    byte[] imagePath = cursor.getBlob(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_PATH));
                    double price = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_PRICE));
                    String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION));
                    BookItem book = new BookItem(id,title, quantity, imagePath, author, cat, price,description);

                    books.add(book);
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return books;
    }
}
