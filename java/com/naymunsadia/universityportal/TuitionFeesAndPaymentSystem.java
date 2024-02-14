package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TuitionFeesAndPaymentSystem extends AppCompatActivity {

    TextView howToPayment;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuition_fees_and_payment_system);

        howToPayment = findViewById(R.id.howToPayment);

        howToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TuitionFeesAndPaymentSystem.this,MoreInformationHowToPayment.class);
                startActivity(intent);

            }
        });


    }
}