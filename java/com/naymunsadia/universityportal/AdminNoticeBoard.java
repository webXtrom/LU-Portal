package com.naeemkhan.universityportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class AdminNoticeBoard extends AppCompatActivity {


    RecyclerView recyclerView;

    AdminNoticeAdapter adminNoticeAdapter;


    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notice_board);

        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminNoticeModel> options = new FirebaseRecyclerOptions.Builder<AdminNoticeModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Notice"), AdminNoticeModel.class).build();

        adminNoticeAdapter = new AdminNoticeAdapter(options);
        recyclerView.setAdapter(adminNoticeAdapter);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminNoticeSave.class));
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        adminNoticeAdapter.startListening();
    }


}




