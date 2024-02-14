package com.naeemkhan.universityportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity{
    TextView signUpTextViewId;
    Button signUpButton;
    EditText inputname,inputemail,inputphn,inputpassword,inputconfirmpassword;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    UserInfo userInfo;


    ProgressDialog progressDialog;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpButton = findViewById(R.id.signUpButton);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        signUpTextViewId = findViewById(R.id.signUpTextViewId);
        inputname =  findViewById(R.id.signUpName);
        inputemail =  findViewById(R.id.signUpEmail);
        inputphn = findViewById(R.id.signUpphn);
        inputpassword =  findViewById(R.id.signUpPassword);
        inputconfirmpassword = findViewById(R.id.inputconfirmpassword);

        progressDialog = new ProgressDialog(this);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("signupUsers");
        mAuth = FirebaseAuth.getInstance();




        signUpTextViewId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));

            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PerforAuth();
            }
        });

    }

    private void PerforAuth() {

        String name= inputname.getText().toString();
        String email= inputemail.getText().toString();
        String phone = inputphn.getText().toString();
        String password= inputpassword.getText().toString();
        String confirmpassword= inputconfirmpassword.getText().toString();

        userInfo = new UserInfo(name,email,phone,password,confirmpassword);

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            inputemail.setError("Enter Correct Email");
        }
        else if (password.isEmpty() || password.length()<6){
            inputpassword.setError("Enter Proper Password");
        } else if (!password.equals(confirmpassword)) {
            inputconfirmpassword.setError("Incorrect Password");


        }else{
            progressDialog.setMessage("Please wait while Register...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            // UserInfo userInfo = new UserInfo(name,email,phone,password,confirmpassword);
            //userInfo();


            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                progressDialog.dismiss();
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                                Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            } else{
                                progressDialog.dismiss();
                                Toast.makeText(SignUpActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
        }


    }

    private void updateUI(FirebaseUser currentUser) {
        String keyid = databaseReference.push().getKey();
        databaseReference.child(keyid).setValue(userInfo);
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
    }
}










