package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultycseButton extends AppCompatActivity {
Button facultycse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultycse_button);
        facultycse=findViewById(R.id.Facultycse);
        facultycse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultycseButton.this,AdminFacultysave.class);
                startActivity(intent);
            }
        });
    }
}