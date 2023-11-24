package com.example.bookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EspaceUtilisateur extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espace_utilisateur);

        BottomNavigationView bott = findViewById(R.id.BottomNavigationView);
        bott.setSelectedItemId(R.id.bottom_home);
        bott.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.bottom_home) {
                return true;
            } else if (id == R.id.bottom_explore) {
                startActivity(new Intent(getApplicationContext(), ExploreActivity.class));
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
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
