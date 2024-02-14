package com.naeemkhan.universityportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddFaculty extends AppCompatActivity {
EditText name,email,number,surl,type;
Button btnadd,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);
        name=(EditText)findViewById(R.id.textname);
        email=(EditText)findViewById(R.id.textemail);
        number=(EditText)findViewById(R.id.textnumber);
        surl=(EditText)findViewById(R.id.textimage);
        type=(EditText)findViewById(R.id.texttype);
        btnadd=(Button) findViewById(R.id.btnadd);
        btnBack=(Button) findViewById(R.id.btnBack);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
insertData();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void insertData()
    {
        Map<String,Object> map =new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("number",number.getText().toString());
        map.put("type",type.getText().toString());
        map.put("email",email.getText().toString());
        map.put("surl",surl.getText().toString());
        FirebaseDatabase.getInstance().getReference("users").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddFaculty.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddFaculty.this, "Error while Insertation", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}