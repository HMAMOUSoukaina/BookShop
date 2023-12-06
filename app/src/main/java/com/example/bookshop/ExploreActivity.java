package com.example.bookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {
ListView booksLsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);


        //Insertion des données dans la base de données
        Context context = getApplicationContext();
        ManualDataInsertion.insertDummyData(context);


//Récupération de la listeView
        booksLsv = findViewById(R.id.lsvBooks);



        //Listeners des différents bouttons
        Button artsButton = findViewById(R.id.arts);
        Button scienceButton = findViewById(R.id.science);
        Button historyButton = findViewById(R.id.history);
        Button literatureButton = findViewById(R.id.literature);
        Button philosophyButton = findViewById(R.id.philosophy);
        Button religionButton = findViewById(R.id.religion);


        setupCategoryButton("Arts", artsButton);
        setupCategoryButton("Science", scienceButton);
        setupCategoryButton("Literature", literatureButton);
        setupCategoryButton("History", historyButton);
        setupCategoryButton("Religion", religionButton);
        setupCategoryButton("Philosophy", philosophyButton);






        artsButton.performClick();

        //Navigation
        BottomNavigationView bott = findViewById(R.id.BottomNavigationView);
        bott.setSelectedItemId(R.id.bottom_explore);
        bott.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), EspaceUtilisateur.class));
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                return true;
            } else if (id == R.id.bottom_explore) {
                return true;
            } else if (id == R.id.bottom_cart) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class));
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                return true;
            }
            return false;
        });
    }


    public void setupCategoryButton(String cat, Button but) {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BooksBDHelper dbHelper = new BooksBDHelper(getApplicationContext());
                List<BookItem> books = dbHelper.getBooksByCategory(cat);
                BookAdapter adapter = new BookAdapter(ExploreActivity.this, books);
                booksLsv.setAdapter(adapter);
            }
        });
    }}
