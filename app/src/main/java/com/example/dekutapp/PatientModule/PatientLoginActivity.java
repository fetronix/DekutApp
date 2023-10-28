package com.example.dekutapp.PatientModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dekutapp.R;

public class PatientLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);

        TextView txtregisterlogin ;
        txtregisterlogin = findViewById(R.id.txtregisterlogin);

        txtregisterlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PatientLoginActivity.this, PatientRegisterActivity.class);
                startActivity(i);
            }
        });
    }
}