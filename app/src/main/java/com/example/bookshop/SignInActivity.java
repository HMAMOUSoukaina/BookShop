package com.example.bookshop;



import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private ImageView imageViewLogo;
    private EditText etEmailSignIn, etPasswordSignIn;
    private Button btnSignIn;
    private TextView tvsignup;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        imageViewLogo = findViewById(R.id.imageViewLogo);
        etEmailSignIn = findViewById(R.id.etEmailSignIn);
        etPasswordSignIn = findViewById(R.id.etPasswordSignIn);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvsignup = findViewById(R.id.tvsignup);
        tvSignUp = findViewById(R.id.tvSignUp);


        underlineText(tvSignUp);


        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Associe un écouteur d'événements au bouton btnSignIn
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupère les valeurs entrées par l'utilisateur dans les champs email et password
                String email = etEmailSignIn.getText().toString();
                String password = etPasswordSignIn.getText().toString();

                // Instancie un objet BDHelper pour interagir avec la base de données
                UsersBDHelper db = new UsersBDHelper(SignInActivity.this);

                // Récupère l'utilisateur correspondant à l'adresse e-mail de la base de données
                User user = db.getUser(email);

                // Vérifie si l'utilisateur existe et si le mot de passe correspond
                if (user != null && user.getPassword().equals(password)) {
                    // L'utilisateur existe et le mot de passe est correct, ouvre l'activité EspaceUtilisateur
                    Intent intent = new Intent(SignInActivity.this, EspaceUtilisateur.class);
                    startActivity(intent);
                } else {
                    // L'utilisateur n'existe pas ou le mot de passe est incorrect
                    Toast.makeText(SignInActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });



        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Sign In activity
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
    private void underlineText(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
    }
    public void signUpClicked(View view) {
        // Open the Sign In activity
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
