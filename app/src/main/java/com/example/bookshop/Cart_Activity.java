package com.example.bookshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.stripe.android.ApiResultCallback;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.Stripe;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import retrofit2.Response;

public class Cart_Activity extends AppCompatActivity {
    private Stripe stripe;
    private CardInputWidget cardInputWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Récupérer les données du panier depuis le singleton
        List<BookItem> itemList = ShoppingCartSingleton.getInstance().getShoppingCart();

        // Obtenir les références des vues
        ListView listView = findViewById(R.id.listviewcart);
        Button backToHomeButton = findViewById(R.id.btncacktohome);
        Button payButton = findViewById(R.id.btnPayer);
        TextView emptyCartTextView = findViewById(R.id.tvemptycart);
        TextView cartTitleTextView = findViewById(R.id.tvcarttitle);

        // Définir le titre du panier
        cartTitleTextView.setText("Panier d'achat");

        // Initialiser l'adaptateur personnalisé avec la liste d'articles
        CartAdapter adapter = new CartAdapter(this, itemList);

        // Obtenir une référence de la ListView et définir l'adaptateur
        listView.setAdapter(adapter);

        // Définir la visibilité de la ListView et du message de panier vide en fonction du contenu du panier
        if (itemList != null && !itemList.isEmpty()) {
            // Le panier n'est pas vide, afficher la ListView et masquer le message de panier vide
            listView.setVisibility(View.VISIBLE);
            emptyCartTextView.setVisibility(View.GONE);
        } else {
            // Le panier est vide, masquer la ListView et afficher le message de panier vide
            listView.setVisibility(View.GONE);
            emptyCartTextView.setVisibility(View.VISIBLE);
        }

        // Définir le gestionnaire de clic pour le bouton "Retour à l'accueil"
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Cart_Activity.this, EspaceUtilisateur.class);
                startActivity(homeIntent);
            }
        });


        payButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(Cart_Activity.this, PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });

    }







}
