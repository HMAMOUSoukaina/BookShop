package com.example.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Cette classe sert de gestionnaire de base de données SQLite
public class UsersBDHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user_db";
    private static final int DATABASE_VERSION = 1;

    // Constructeur de la classe BDHelper
    public UsersBDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Méthode appelée lors de la création de la base de données
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Requête SQL pour créer la table "users"
        String CREATE_USERS_TABLE = "CREATE TABLE users " +
                "(name TEXT, phone TEXT, email TEXT PRIMARY KEY, password TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    // Méthode appelée lors de la mise à niveau de la base de données
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Supprime la table existante et recrée une nouvelle version
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    // Méthode pour ajouter un utilisateur à la base de données
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Crée un objet ContentValues pour stocker les paires clé-valeur à insérer dans la base de données
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("phone", user.getPhone());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        // Insère les valeurs dans la table "users"
        db.insert("users", null, values);

        // Ferme la connexion à la base de données
        db.close();
    }

    // Méthode pour obtenir un utilisateur par son adresse e-mail
    public User getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Effectue une requête pour obtenir un curseur pointant vers l'utilisateur correspondant à l'adresse e-mail
        Cursor cursor = db.query("users",
                new String[]{"name", "phone", "email", "password"},
                "email=?",
                new String[]{email}, null, null, null, null);

        // Déplace le curseur à la première ligne (s'il y a des résultats)
        if (cursor != null)
            cursor.moveToFirst();

        // Crée un objet User avec les valeurs du curseur
        User user = new User(
                cursor.getString(0),   // Colonne "name"
                cursor.getString(1),   // Colonne "phone"
                cursor.getString(2),   // Colonne "email"
                cursor.getString(3)    // Colonne "password"
        );

        // Retourne l'utilisateur
        return user;
    }
}
