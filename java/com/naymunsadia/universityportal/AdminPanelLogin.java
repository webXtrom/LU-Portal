package com.naeemkhan.universityportal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AdminPanelLogin extends AppCompatActivity {

    Button adminSignInButton;

    EditText adminSignInEmail,adminSignInPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel_login);


        adminSignInButton = findViewById(R.id.adminSignInButton);
        adminSignInEmail = findViewById(R.id.adminSignInEmail);
        adminSignInPassword = findViewById(R.id.adminSignInPassword);


        adminSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               String myString = adminSignInEmail.getText().toString();
               String numString = adminSignInPassword.getText().toString();

               /*int myNumber = Integer.parseInt(numString);*/

               if((myString.equals("admin@gmail.com"))&&(numString.equals("admin"))){

                   Intent intent = new Intent(AdminPanelLogin.this,AdminHomePanel.class);
                   startActivity(intent);

               }else {
                   Toast.makeText(AdminPanelLogin.this,"Enter email and password",Toast.LENGTH_LONG).show();
               }

            }
        });


    }
}