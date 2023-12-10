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

public class PaymentActivity extends AppCompatActivity {
    private Stripe stripe;
    private CardInputWidget cardInputWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button payButton = findViewById(R.id.paybutton);

        PaymentConfiguration.init(getApplicationContext(), "pk_test_51OL2YBBXngEF9Vjjw6GlH69bAI1HWjjH3sJmAzflGNsbJhcCnP3C78I8x7R4kKYkXKvUCmKxGazRTm3boGSShb8m00OPmelNHl");

        stripe = new Stripe(getApplicationContext(),"pk_test_51OL2YBBXngEF9Vjjw6GlH69bAI1HWjjH3sJmAzflGNsbJhcCnP3C78I8x7R4kKYkXKvUCmKxGazRTm3boGSShb8m00OPmelNHl");

        cardInputWidget = findViewById(R.id.cardInputWidget);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payerAvecCarte();
            }
        });
    }

    private void payerAvecCarte() {
        stripe.createCardToken(
                cardInputWidget.getCardParams(),
                new ApiResultCallback<Token>() {
                    @Override
                    public void onSuccess(Token result) {
                        // Utilisez result.getId() pour obtenir le jeton de paiement
                        String tokenId = result.getId();
                        // Envoyez le tokenId à votre serveur pour traiter le paiement

                        // Vous devez traiter le paiement côté serveur pour des raisons de sécurité
                        Toast.makeText(PaymentActivity.this, "Paiement réussi", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error
                        Toast.makeText(PaymentActivity.this, "Erreur : " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private class TokenCallback implements retrofit2.Callback<Token> {
        @Override
        public void onResponse(@NonNull retrofit2.Call<Token> call, @NonNull Response<Token> response) {
            if (response.isSuccessful()) {
                // Utilisez response.body().getId() pour obtenir le jeton de paiement
                String tokenId = response.body().getId();
                // Envoyez le tokenId à votre serveur pour traiter le paiement



                Toast.makeText(PaymentActivity.this, "Paiement réussi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PaymentActivity.this, "Échec du paiement", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(@NonNull retrofit2.Call<Token> call, @NonNull Throwable t) {
            Toast.makeText(PaymentActivity.this, "Erreur : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }



}
