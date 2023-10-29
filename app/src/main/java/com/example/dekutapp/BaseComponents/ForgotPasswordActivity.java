package com.example.dekutapp.BaseComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dekutapp.DoctorModule.DoctorLoginActivity;
import com.example.dekutapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextView forgotspalshhome ;
        forgotspalshhome = findViewById(R.id.backtosplash);

        forgotspalshhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgotPasswordActivity.this, SplashActivity.class);
                startActivity(i);
            }
        });
    }
}