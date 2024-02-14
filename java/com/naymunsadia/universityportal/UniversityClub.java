package com.naeemkhan.universityportal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class UniversityClub extends AppCompatActivity {

    ViewFlipper clubSlidFlipper;

    Button luCc,luSc,luDc,orpheusLu,bannedCommunity,ieeeLu,lusSc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_club);



        luCc = findViewById(R.id.luCc);
        luSc = findViewById(R.id.luSc);
        luDc = findViewById(R.id.luDc);
        orpheusLu = findViewById(R.id.orpheusLu);
        bannedCommunity = findViewById(R.id.bannedCommunity);
        ieeeLu = findViewById(R.id.ieeeLu);
        lusSc = findViewById(R.id.lusSc);



        // slid show club

        int imgClub[] ={R.drawable.club_lucc1,R.drawable.club_bc2,R.drawable.club_lusc3,R.drawable.club_ieee4,R.drawable.club_lussc6,R.drawable.club_ludc5,R.drawable.club_orphus7};
        clubSlidFlipper = findViewById(R.id.clubSlidFlipper);

        for (int i=0; i<imgClub.length; i++)
            showImageClub(imgClub[i]);



        luCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/groups/332845222045475/?ref=share&mibextid=NSMWBT&_rdc=1&_rdr";

                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);
            }
        });

        luSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/LUSC.OFFICIAL2003?mibextid=ZbWKwL&_rdc=1&_rdr";

                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);

            }
        });

        luDc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/groups/ludc.champs/?ref=share&mibextid=NSMWBT&_rdc=1&_rdr";
                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);

            }
        });

        orpheusLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/orpheus.lu?mibextid=ZbWKwL&_rdc=1&_rdr";
                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);

            }
        });

        bannedCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/BANNED.SYL?mibextid=ZbWKwL&_rdc=1&_rdr";
                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);

            }
        });

        ieeeLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/ieeelusb.org";
                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);

            }
        });

        lusSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversityClubFacebookGroupLink.group_link = "https://web.facebook.com/groups/175780292538153/?ref=share&mibextid=NSMWBT&_rdc=1&_rdr";
                Intent intent = new Intent(UniversityClub.this,UniversityClubFacebookGroupLink.class);
                startActivity(intent);

            }
        });



    }

    // Slid view show function

    public void showImageClub(int img){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        clubSlidFlipper.addView(imageView);
        clubSlidFlipper.setFlipInterval(1000);
        clubSlidFlipper.setAutoStart(true);

        clubSlidFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        clubSlidFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }


}