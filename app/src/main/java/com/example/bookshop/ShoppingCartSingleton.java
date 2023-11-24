package com.example.bookshop;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSingleton {
    private static final ShoppingCartSingleton instance = new ShoppingCartSingleton();
    private List<BookItem> shoppingCart;

    private ShoppingCartSingleton() {
        shoppingCart = new ArrayList<>();
    }

    public static ShoppingCartSingleton getInstance() {
        return instance;
    }

    public List<BookItem> getShoppingCart() {
        return shoppingCart;
    }

    public void addToCart(BookItem bookItem) {
        shoppingCart.add(bookItem);
    }
}

