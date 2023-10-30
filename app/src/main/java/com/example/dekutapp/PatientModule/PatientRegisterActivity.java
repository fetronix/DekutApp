package com.example.dekutapp.PatientModule;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.dekutapp.R;


public class PatientRegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        final TextView patientasklog = findViewById(R.id.patientsasklogin);
        patientasklog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PatientRegisterActivity.this,PatientLoginActivity.class));
            }
        });

    }
}