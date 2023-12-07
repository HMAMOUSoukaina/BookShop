package com.example.bookshop;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import android.content.Intent;

public class Cart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Retrieve the shopping cart data from the singleton
        List<BookItem> itemList = ShoppingCartSingleton.getInstance().getShoppingCart();

        // Get references to views
        ListView listView = findViewById(R.id.listviewcart);
        Button backToHomeButton = findViewById(R.id.btncacktohome);
        TextView emptyCartTextView = findViewById(R.id.tvemptycart);
        TextView cartTitleTextView = findViewById(R.id.tvcarttitle);

        // Set the cart title
        cartTitleTextView.setText("Shopping Cart");

        // Initialize the custom adapter with the item list
        CartAdapter adapter = new CartAdapter(this, itemList);

        // Get a reference to the ListView and set the adapter to it
        listView.setAdapter(adapter);

        // Set the visibility of ListView and empty cart message based on the cart content
        if (itemList != null && !itemList.isEmpty()) {
            // Cart is not empty, show the ListView and hide the empty cart message
            listView.setVisibility(View.VISIBLE);
            emptyCartTextView.setVisibility(View.GONE);
        } else {
            // Cart is empty, hide the ListView and show the empty cart message
            listView.setVisibility(View.GONE);
            emptyCartTextView.setVisibility(View.VISIBLE);
        }

        // Set the click listener for the "Back to Home" button
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Cart_Activity.this, EspaceUtilisateur.class);
                startActivity(homeIntent);
            }
        });
    }
}



