package com.example.bookshop;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookPageActivity extends AppCompatActivity {
/*
    private ImageView imageViewBookCover;
    private TextView tvBookTitle, tvBookAuthor, tvBookPrice, tvBookRating,
            tvBookPages, tvBookLanguage, tvBookDescription, tvQuantity;
    private Button btnAddToCart, favoriteButton;
    private int quantity = 1; // Initial quantity
    private List<BookItem> shoppingCart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);

        // Initialize views
        imageViewBookCover = findViewById(R.id.imageViewBookCover);
        tvBookTitle = findViewById(R.id.tvBookTitle);
        tvBookAuthor = findViewById(R.id.tvBookAuthor);
        tvBookPrice = findViewById(R.id.tvBookPrice);
        tvBookRating = findViewById(R.id.tvBookRating);
        tvBookPages = findViewById(R.id.tvBookPages);
        tvBookLanguage = findViewById(R.id.tvBookLanguage);
        tvBookDescription = findViewById(R.id.tvBookDescription);
        tvQuantity = findViewById(R.id.tvQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        favoriteButton = findViewById(R.id.buttonFavorite);

        // Set dummy data (replace with actual book data)
        imageViewBookCover.setImageResource(R.drawable.book_cover); // Replace with actual image resource
        tvBookTitle.setText("Book Title");
        tvBookAuthor.setText("Author Name");
        tvBookPrice.setText("$19.99");
        tvBookRating.setText("4.5");
        tvBookPages.setText("300 pages");
        tvBookLanguage.setText("English");
        tvBookDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");



        // Minus button click listener
        ImageView imageViewMinus = findViewById(R.id.imageViewMinus);
        imageViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuantity(false);
            }
        });

        // Plus button click listener
        ImageView imageViewPlus = findViewById(R.id.imageViewPlus);
        imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuantity(true);
            }
        });

        // Add to Cart button click listener
        // Inside the btnAddToCart.setOnClickListener
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a BookItem with the book details
                BookItem bookItem = new BookItem(
                        tvBookTitle.getText().toString(),
                        quantity,
                        R.drawable.book_cover // Replace with your actual image resource
                );

                // Add the BookItem to the shopping cart
                ShoppingCartSingleton.getInstance().addToCart(bookItem);

                // Create an Intent to start the CartActivity
                Intent cartIntent = new Intent(BookPageActivity.this, Cart_Activity.class);

                // Start the CartActivity
                startActivity(cartIntent);

                // You can display a toast or perform other actions to indicate successful addition
                Toast.makeText(BookPageActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateQuantity(boolean increment) {
        // Update the quantity and display
        if (increment) {
            quantity++;
        } else {
            if (quantity > 1) {
                quantity--;
            }
        }
        tvQuantity.setText(String.valueOf(quantity));
    }
    */

}
