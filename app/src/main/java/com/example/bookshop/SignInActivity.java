package com.example.bookshop;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText etEmailSignIn, etPasswordSignIn;
    private Button btnSignIn;
    private TextView tvsignup;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etEmailSignIn = findViewById(R.id.etEmailSignIn);
        etPasswordSignIn = findViewById(R.id.etPasswordSignIn);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvsignup = findViewById(R.id.tvsignup);
        tvSignUp = findViewById(R.id.tvSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailSignIn.getText().toString();
                String password = etPasswordSignIn.getText().toString();

                UsersBDHelper db = new UsersBDHelper(SignInActivity.this);
                User user = db.getUser(email);

                if (user != null && user.getPassword().equals(password)) {
                    Intent intent = new Intent(SignInActivity.this, EspaceUtilisateur.class);
                    intent.putExtra("USER_EMAIL", user.getEmail());
                    startActivity(intent);
                } else {
                    Toast.makeText(SignInActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        underlineText(tvSignUp);
    }
    private void underlineText(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
    }
}
