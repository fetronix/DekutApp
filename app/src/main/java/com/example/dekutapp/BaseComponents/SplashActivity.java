package com.example.dekutapp.BaseComponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dekutapp.AdminModule.AddDoctorActivity;
import com.example.dekutapp.AdminModule.AdminDashboardActivity;
import com.example.dekutapp.DoctorModule.DoctorDashboardActivity;
import com.example.dekutapp.DoctorModule.DoctorLoginActivity;
import com.example.dekutapp.PatientModule.PatientDashboardActivity;
import com.example.dekutapp.PatientModule.PatientLoginActivity;
import com.example.dekutapp.PatientModule.PatientRegisterActivity;
import com.example.dekutapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button doctorsplash ,patientsplash ;
        doctorsplash = findViewById(R.id.btnroledoctor);
        patientsplash = findViewById(R.id.btnrolepatient);

        doctorsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashActivity.this, DoctorLoginActivity.class);
                startActivity(i);
            }
        });

        patientsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashActivity.this, PatientLoginActivity.class);
                startActivity(i);
            }
        });

    }
}