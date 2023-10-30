package com.example.dekutapp.DoctorModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dekutapp.R;

public class DoctorLoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        final TextView docaskrgiter = findViewById(R.id.doctoraskregister);
        docaskrgiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorLoginActivity.this,DoctorRegisterActivity.class));
                finish();
            }
        });

    }
}