package com.example.dekutapp.PatientModule;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dekutapp.R;

public class PatientRegisterActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);

        TextView txtloginrgister ;
        txtloginrgister = findViewById(R.id.txtloginregister);

        txtloginrgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PatientRegisterActivity.this, PatientLoginActivity.class);
                startActivity(i);
            }
        });
    }
}