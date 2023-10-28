package com.example.dekutapp.AdminModule;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dekutapp.BaseComponents.MpesaActivity;
import com.example.dekutapp.R;

public class AdminDashboardActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

       Button btnpay ;
       btnpay =findViewById(R.id.buttonmpay);
       btnpay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(AdminDashboardActivity.this, MpesaActivity.class);
               startActivity(i);
           }
       });




    }
}