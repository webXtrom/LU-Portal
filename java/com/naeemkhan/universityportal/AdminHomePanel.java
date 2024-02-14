package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class AdminHomePanel extends AppCompatActivity {

    Button studentPortal,noticeboard,adminfacultysave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_panel);

        studentPortal = findViewById(R.id.studentPortal);
       noticeboard = findViewById(R.id.notice);
adminfacultysave=findViewById(R.id.facultyBoard);
        studentPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomePanel.this,AdminStudent.class);
                startActivity(intent);
            }
        });
        noticeboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomePanel.this,AdminNoticeBoard.class);
                startActivity(intent);
            }
        });

        adminfacultysave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomePanel.this,FacultycseButton.class);
                startActivity(intent);
            }
        });


    }
}