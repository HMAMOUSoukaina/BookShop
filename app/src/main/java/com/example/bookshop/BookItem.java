package com.example.bookshop;

import java.io.Serializable;

public class BookItem implements Serializable {
    private final String title;
    private final int quantity;
    private final int imageUrl;

   /* public void setTitle(String title) {
        this.title = title;
    }

    public BookItem() {
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }*/

    public BookItem(){
        this.title="Some title";
        this.quantity=0;
        this.imageUrl=1;
    }

    public BookItem(String title, int quantity, int imageUrl) {
        this.title = title;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }


    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}