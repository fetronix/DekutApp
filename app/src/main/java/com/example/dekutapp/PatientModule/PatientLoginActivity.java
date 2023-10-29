package com.example.dekutapp.PatientModule;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dekutapp.BaseComponents.ForgotPasswordActivity;
import com.example.dekutapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PatientLoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    AlertDialog.Builder builder;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

       TextView text_register_login = findViewById(R.id.txtregisterlogin);
        TextView txtpatientforgot = findViewById(R.id.txtloginforgotpassword);

        txtpatientforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showrecoverPasswordDialogBox();
            }

            private void showrecoverPasswordDialogBox() {

//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder = new AlertDialog.Builder(PatientLoginActivity.this);
                builder.setTitle("Dekut Medic Password Recovery");

                LinearLayout linearLayout = new LinearLayout(PatientLoginActivity.this);

                final EditText emailet = new EditText(PatientLoginActivity.this);
                emailet.setHint("email");
                emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                emailet.setMinEms(16);

                linearLayout.addView(emailet);
                linearLayout.setPadding(10,10,10,10);

                builder.setView(linearLayout);

                builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            String email = emailet.getText().toString().trim();
                            begingRecovery(email);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.create().show();


            }
        });



        text_register_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PatientLoginActivity.this,PatientRegisterActivity.class));
                finish();
            }
        });

        EditText edtpatientemail, edtpatientpassword;
        Button patientlogin = findViewById(R.id.btnpatientlogin);
        edtpatientemail = findViewById(R.id.edtloginemail);
        edtpatientpassword = findViewById(R.id.edtloginpassword);


        progressDialog = new ProgressDialog(this);



        patientlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    loginPatientUser(email,password);
                }


            }
        });


    }

    private void begingRecovery(String email) {
        progressDialog.setTitle("Dekut Medic App");
        progressDialog.setMessage("Sending email");
        progressDialog.show();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(PatientLoginActivity.this, "Email has been sent", Toast.LENGTH_SHORT).show();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(PatientLoginActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PatientLoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginPatientUser(String email, String password) {
        progressDialog.setTitle("Dekut Medic App");
        progressDialog.setMessage("please wait while logging");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(PatientLoginActivity.this,PatientDashboardActivity.class));
                            finish();

                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(PatientLoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(PatientLoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}