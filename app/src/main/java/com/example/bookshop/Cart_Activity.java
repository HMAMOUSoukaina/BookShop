package com.example.bookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Cart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        //Navigation
        BottomNavigationView bott = findViewById(R.id.BottomNavigationView);
        bott.setSelectedItemId(R.id.bottom_cart);
        bott.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), EspaceUtilisateur.class));
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                return true;
            } else if (id == R.id.bottom_explore) {
                startActivity(new Intent(getApplicationContext(), ExploreActivity.class));
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                return true;
            } else if (id == R.id.bottom_cart) {

                return true;
            }

            return false;
        });
    }
    }
