package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class BusUpDate extends AppCompatActivity {

    WebView webViewTransport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_up_date);

        webViewTransport =findViewById(R.id.webViewTransport);
        webViewTransport.getSettings().setJavaScriptEnabled(true);
        webViewTransport.loadUrl("https://web.facebook.com/profile.php?id=100076156563920");

    }
}