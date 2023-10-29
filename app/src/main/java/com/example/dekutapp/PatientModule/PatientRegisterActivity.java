package com.example.dekutapp.PatientModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dekutapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Context;

public class PatientRegisterActivity extends AppCompatActivity {

    ProgressDialog  progressDialog;
    FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);


        //        initaiting firebase instatnce for saving record

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        TextView txtloginrgister ;
        txtloginrgister = findViewById(R.id.txtloginregister);

        txtloginrgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PatientRegisterActivity.this, PatientLoginActivity.class);
                startActivity(i);
                finish();
            }
        });

//        initializing varibales of registeration
        Button btnregisterpatient = findViewById(R.id.btnpatientregister);
        EditText edtpatientnames = findViewById(R.id.edtregname);
        EditText edtpatientemail = findViewById(R.id.edtregemail);
        EditText edtpatientpassword = findViewById(R.id.edtregpassword);


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Dekut medic App");
        progressDialog.setMessage("Registration in process....");



//        Handling the image view button on click to register
        btnregisterpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input email password
                String email = edtpatientemail.getText().toString().trim();
                String password = edtpatientpassword.getText().toString().trim();

//                Validation of above values
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    //set error amd focus on email edtext
                    edtpatientemail.setError("invalid email");
                    edtpatientemail.setFocusable(true);
                }
                else if (password.length()<6){
                    edtpatientpassword.setError("password is too short < 6 characters ");
                    edtpatientpassword.setFocusable(true);
                }
                else {
                    registerPatientUser(email,password);
                }
            }
        });
    }

    private void registerPatientUser(String email, String password) {
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            dismiss dialogg
                            FirebaseUser user = mAuth.getCurrentUser();
                            progressDialog.dismiss();
                            startActivity(new Intent(PatientRegisterActivity.this,PatientDashboardActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss();
                            Toast.makeText(PatientRegisterActivity .this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //dismiss dialog box and show the error message
                        progressDialog.dismiss();
                        Toast.makeText(PatientRegisterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}