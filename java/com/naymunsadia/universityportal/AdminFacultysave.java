package com.naeemkhan.universityportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminFacultysave extends AppCompatActivity {
    RecyclerView recyclerView;
    AdminAdaptercse adminAdaptercse;
    FloatingActionButton floatingActionButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_facultysave);
        recyclerView = (RecyclerView) findViewById(R.id.rvv);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("users"), MainModel.class).build();
        adminAdaptercse = new AdminAdaptercse(options);
        recyclerView.setAdapter(adminAdaptercse);

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddFaculty.class));
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        adminAdaptercse.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adminAdaptercse.stopListening();
    }
}