package com.example.bookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {
ListView booksLsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);


        //Travail avec la listView
        booksLsv = findViewById(R.id.lsvBooks);
        ArrayList<BookItem> arr = new ArrayList<>();
        while (arr.size()<10){
            arr.add(new BookItem());

        }

        BookAdapter adaper = new BookAdapter( this,0,arr);
        booksLsv.setAdapter(adaper);




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
    }
