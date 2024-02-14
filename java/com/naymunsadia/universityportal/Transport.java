package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Transport extends AppCompatActivity {

    ViewFlipper busSlidFlipper;

    TextView route1,route2,route3,route4;
    Button busUpdate;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        route1 = findViewById(R.id.route1);
        route2 = findViewById(R.id.route2);
        route3 = findViewById(R.id.route3);
        route4 = findViewById(R.id.route4);
        busUpdate = findViewById(R.id.busUpdate);


        // Slid view show

        int showImageBus[] ={R.drawable.bus_slid1,R.drawable.bus_slid3,R.drawable.bus_slide2};
        busSlidFlipper = findViewById(R.id.busSlidFlipper);

        for (int i=0; i<showImageBus.length; i++)
            showImageBus(showImageBus[i]);




        route1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transport.this,Route1.class);
                startActivity(intent);
            }
        });

        route2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transport.this,Route2.class);
                startActivity(intent);
            }
        });

        route3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transport.this,Route3.class);
                startActivity(intent);
            }
        });

        route4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transport.this,Route4.class);
                startActivity(intent);
            }
        });

        busUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transport.this,BusUpDate.class);
                startActivity(intent);
            }
        });





    }

    // Slid view show function

    public void showImageBus(int img){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        busSlidFlipper.addView(imageView);
        busSlidFlipper.setFlipInterval(2000);
        busSlidFlipper.setAutoStart(true);

        busSlidFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        busSlidFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }




}