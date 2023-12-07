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
                    COLUMN_IMAGE_PATH + " BLOB);"; // Changed from TEXT to BLOB

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
                    BookItem book = new BookItem(id,title, quantity, imagePath, author, cat, price);

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


    // Méthode pour récupérer tous les livres dans la base de données
    public List<BookItem> getAllBooks() {
        List<BookItem> books = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(
                    TABLE_BOOKS,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                    int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTITY));
                    String author = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTHOR));
                    String cat = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY));
                    byte[] imagePath = cursor.getBlob(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_PATH));
                    double price = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_PRICE));
                    BookItem book = new BookItem(id, title, quantity, imagePath, author, cat, price);

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

    // Méthode pour récupérer un livre par son ID
    public BookItem getBookById(int bookId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        BookItem book = null;

        try {
            cursor = db.query(
                    TABLE_BOOKS,
                    null,
                    COLUMN_ID + "=?",
                    new String[]{String.valueOf(bookId)},
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTITY));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTHOR));
                String cat = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY));
                byte[] imagePath = cursor.getBlob(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_PATH));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_PRICE));
                book = new BookItem(bookId, title, quantity, imagePath, author, cat, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return book;
    }

    // Méthode pour récupérer l'image d'un livre par son ID en tant que tableau de bytes
    public byte[] getBookImageById(BookItem book) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        byte[] imagePath = null;

        try {
            cursor = db.query(
                    TABLE_BOOKS,
                    new String[]{COLUMN_IMAGE_PATH},
                    COLUMN_ID + "=?",
                    new String[]{String.valueOf(book.getId())}, // Utilisez l'ID du livre
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                imagePath = cursor.getBlob(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_PATH));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return imagePath;
    }

}
