package com.example.bookshop;

import java.io.Serializable;

public class BookItem implements Serializable {
    private final String title;
    private final int quantity;
    private final String imagePath; // Remplacé imageUrl par le chemin de l'image
    public final String author;
    public final String category;
    public final double Price ;



    public BookItem() {
        this.title = "Some title";
        this.quantity = 0;
        this.imagePath = ""; // Initialisé avec une chaîne vide
        this.author = "";
        this.category = "";
        this.Price=0;
    }

    public BookItem(String title, int quantity, String imagePath, String author, String category,double Price) {
        this.title = title;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.author = author;
        this.category = category;
        this.Price=Price;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImagePath() {
        return imagePath;
    }
}
