package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class MoreInformationHowToPayment extends AppCompatActivity {

    WebView paymentYoutubeVideo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information_how_to_payment);

        paymentYoutubeVideo = findViewById(R.id.paymentYoutubeVideo);

        paymentYoutubeVideo.getSettings().setJavaScriptEnabled(true);

        paymentYoutubeVideo.loadUrl("https://www.youtube.com/watch?v=se9ya_2pa88");


    }
}