package com.example.bookshop;

import java.io.Serializable;

public class BookItem implements Serializable {
    private final String title;
    private final int id;
    private final int quantity;
    private final byte[] imagePath; // Changed from String to byte[]
    public final String author;
    public final String category;
    public final double Price;

    public BookItem() {
        this.title = "Some title";
        this.quantity = 0;
        this.imagePath = new byte[0]; // Initialize with an empty byte array
        this.author = "";
        this.category = "";
        this.Price = 0;
        this.id=0;
    }

    public BookItem(int id,String title, int quantity, byte[] imagePath, String author, String category, double Price) {
        this.title = title;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.author = author;
        this.category = category;
        this.Price = Price;
        this.id=id;
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


    public int getId(){
        return id;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public byte[] getImagePath() {
        return imagePath;
    }
}
