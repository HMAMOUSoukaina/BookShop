package com.example.bookshop;



import android.content.Intent;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;





public class BookPageActivity extends AppCompatActivity {


    private ImageView imageViewBookCover;
    private TextView tvBookTitle, tvBookAuthor, tvBookPrice, tvBookRating,
            tvBookPages, tvBookLanguage, tvBookDescription, tvQuantity, tvBookCategory;
    private Button btnAddToCart;
    private int quantity = 1;


    private byte[] bookImage;
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
        tvBookCategory = findViewById(R.id.tvBookCategory);
        tvBookLanguage = findViewById(R.id.tvBookLanguage);
        tvBookDescription = findViewById(R.id.tvBookDescription);
        tvQuantity = findViewById(R.id.tvQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        // Get the BookItem passed from ExploreActivity
        Intent intent = getIntent();
        if (intent.hasExtra("bookId")) {
            long bookId = intent.getLongExtra("bookId", -1);

            // Retrieve book details from the database
            BooksBDHelper dbHelper = new BooksBDHelper(this);
            BookItem bookItem = dbHelper.getBookById((int) bookId);
            bookImage = dbHelper.getBookImageById(bookItem);

            // Set the views with book details
            if (bookItem != null) {
                // Load image using BitmapUtils
                Bitmap bookCoverBitmap = BitmapUtils.getBitmapFromByteArray(bookItem.getImagePath());
                imageViewBookCover.setImageBitmap(bookCoverBitmap);
                tvBookTitle.setText(bookItem.getTitle());
                tvBookAuthor.setText(bookItem.getAuthor());
                tvBookPrice.setText(bookItem.getPrice()+"$");
                tvBookCategory.setText(bookItem.getCategory());
                tvBookRating.setText("4.5");  // Replace with actual rating
                tvBookPages.setText("300 pages");  // Replace with actual page count
                tvBookLanguage.setText("English");  // Replace with actual language
                tvBookDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
            }
        }

        // Minus button click listener
        ImageView imageViewMinus = findViewById(R.id.imageViewMinus);
        imageViewMinus.setOnClickListener(v -> updateQuantity(false));

        // Plus button click listener

        ImageView imageViewPlus = findViewById(R.id.imageViewPlus);
        imageViewPlus.setOnClickListener(v -> updateQuantity(true));


        // Add to Cart button click listener
        btnAddToCart.setOnClickListener(v -> {


            // Create a BookItem with the book details
            BookItem bookItem = new BookItem(

                    tvBookTitle.getText().toString(),
                    quantity,
                    bookImage // Replace with your actual image resource
            );

            // Add the BookItem to the shopping cart
            ShoppingCartSingleton.getInstance().addToCart(bookItem);

            // Display a toast indicating successful addition to cart
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();
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



}
