package com.example.bookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class EspaceUtilisateur extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espace_utilisateur);

        // Récupérez la ListView
        ListView booksListView = findViewById(R.id.booksListView);

        // Récupérez les informations de l'utilisateur depuis l'intent
        Intent intent = getIntent();
        if (intent.hasExtra("USER_EMAIL")) {
            String userEmail = intent.getStringExtra("USER_EMAIL");

            // Utilisez l'e-mail de l'utilisateur pour récupérer les informations de l'utilisateur depuis la base de données
            UsersBDHelper usersDbHelper = new UsersBDHelper(getApplicationContext());
            User user = usersDbHelper.getUser(userEmail);

            // Mettez à jour les TextViews avec les informations de l'utilisateur
            TextView textViewUserName = findViewById(R.id.textViewUserName);


            textViewUserName.setText("Hello " + user.getName());

        }

        // Récupérez tous les livres de la base de données
        BooksBDHelper dbHelper = new BooksBDHelper(getApplicationContext());
        List<BookItem> books = dbHelper.getAllBooks();

        // Créez un adaptateur pour la ListView
        BookAdapter adapter = new BookAdapter(this, books);

        // Définissez l'adaptateur sur la ListView
        booksListView.setAdapter(adapter);





        booksListView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected BookItem
            BookItem selectedBook = (BookItem) parent.getItemAtPosition(position);

            // Create an Intent to start the BookPageActivity
            Intent bookPageIntent = new Intent(EspaceUtilisateur.this, BookPageActivity.class);

            // Pass the selected book details to BookPageActivity
            bookPageIntent.putExtra("bookId", selectedBook.getId());
            bookPageIntent.putExtra("bookTitle", selectedBook.getTitle());
            bookPageIntent.putExtra("bookAuthor", selectedBook.getAuthor());
            bookPageIntent.putExtra("bookPrice", selectedBook.getPrice());

            // Start the BookPageActivity
            startActivity(bookPageIntent);
        });



        BottomNavigationView bott = findViewById(R.id.BottomNavigationView);
        bott.setSelectedItemId(R.id.bottom_home);
        bott.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.bottom_home) {
                return true;
            } else if (id == R.id.bottom_explore) {
                startActivity(new Intent(getApplicationContext(), ExploreActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                return true;
            } else if (id == R.id.bottom_cart) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                return true;
            }
            return false;
        });
    }
}







