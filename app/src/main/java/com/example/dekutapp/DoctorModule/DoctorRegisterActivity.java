package com.example.dekutapp.DoctorModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dekutapp.R;

public class DoctorRegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        final TextView doctorask = findViewById(R.id.doctorasklogin);

        doctorask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorRegisterActivity.this,DoctorLoginActivity.class));
                finish();
            }
        });

    }
}