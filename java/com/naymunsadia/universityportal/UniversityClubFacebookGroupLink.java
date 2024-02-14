package com.naeemkhan.universityportal;

import static com.naeemkhan.universityportal.R.id.universityClubFacebookGroupLink;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class UniversityClubFacebookGroupLink extends AppCompatActivity {

    WebView universityClubFacebookGroupLink;
    public static String group_link = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_club_facebook_group_link);

        universityClubFacebookGroupLink = findViewById(R.id.universityClubFacebookGroupLink);

        universityClubFacebookGroupLink.getSettings().setJavaScriptEnabled(true);
        universityClubFacebookGroupLink.loadUrl(group_link);



    }
}