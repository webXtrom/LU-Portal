package com.naeemkhan.universityportal;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AdminNoticeSave extends AppCompatActivity {

    EditText text;
    EditText image;
    Button addbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notice_save);


        text = (EditText) findViewById(R.id.ettext1);
        image = (EditText) findViewById(R.id.etimage1);

        addbtn = (Button) findViewById(R.id.addbtn);




        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                ClearAll();

            }
        });

    }

    int counter = 0;
    @Override
    public void onBackPressed() {

        counter++;
        if(counter == 2)
            super.onBackPressed();

    }



    private void insertData(){
        Map<String, Object> map = new HashMap<>();

        map.put("Text", text.getText().toString());
        map.put("image",image.getText().toString());


        FirebaseDatabase.getInstance().getReference("Notice")
                .push().setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AdminNoticeSave.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AdminNoticeSave.this, "Error while insertion.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void ClearAll() {
        text.setText("");
        image.setText("");
    }
}
