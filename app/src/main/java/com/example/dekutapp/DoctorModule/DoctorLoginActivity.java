package com.example.dekutapp.DoctorModule;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dekutapp.BaseComponents.ForgotPasswordActivity;
import com.example.dekutapp.PatientModule.PatientLoginActivity;
import com.example.dekutapp.PatientModule.PatientRegisterActivity;
import com.example.dekutapp.R;

public class DoctorLoginActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);


    }
}