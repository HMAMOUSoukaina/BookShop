package com.example.bookshop;



import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement your sign-in logic here
                Toast.makeText(SignInActivity.this, "Sign In Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
