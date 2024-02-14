package com.naeemkhan.universityportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;

    NavigationView navigationView;

    ViewFlipper luSlidFlipper;

    FirebaseAuth mAuth;

    Toolbar toolbar;

    Button noticeButton,aboutUsButton,admissionButton,facultyMemberButton,studentButton,
            universityClubButton,transportButton,contactButtonUs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //introduce Button


        mAuth = FirebaseAuth.getInstance();
        noticeButton = findViewById(R.id.NoticeButton);
        aboutUsButton = findViewById(R.id.aboutUsButton);
        admissionButton = findViewById(R.id.admissionButton);
        facultyMemberButton = findViewById(R.id.facultyMemberButton);
        studentButton = findViewById(R.id.studentButton);
        universityClubButton = findViewById(R.id.universityClubButton);
        transportButton = findViewById(R.id.transportButton);
        contactButtonUs = findViewById(R.id.contactButtonUs);


        // Slid view show

        int imgarray[] = {R.drawable.lu_slid1, R.drawable.lu_sild2, R.drawable.lu_slid3, R.drawable.lu_slid4, R.drawable.lu_slid5};
        luSlidFlipper = findViewById(R.id.luSlidFlipper);

        for (int i = 0; i < imgarray.length; i++)
            showimage(imgarray[i]);


        // go to next page
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to next page (aboutus)
                Intent myintent = new Intent(Home.this, NoticeBoard.class);
                startActivity(myintent);
            }
        });


        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to next page (aboutus)
                Intent myintent = new Intent(Home.this, AboutUs.class);
                startActivity(myintent);
            }
        });

        admissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Admission.class);
                startActivity(intent);
            }
        });

        facultyMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, FacultyMembers.class);
                startActivity(intent);
            }
        });

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Students.class);
                startActivity(intent);
            }
        });

        universityClubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, UniversityClub.class);
                startActivity(intent);
            }
        });

        transportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Transport.class);
                startActivity(intent);
            }
        });

        contactButtonUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ContactUs.class);
                startActivity(intent);
            }
        });


        //navigation bar

        drawerLayout = findViewById(R.id.homeAbout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);


        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.menu_home) {
                    loadFragment(new Afragment());


                } else if (id == R.id.menu_profile) {

                } else if (id == R.id.menu_logout) {

                    FirebaseAuth.getInstance().signOut();
                    Intent mainActivity = new Intent(Home.this, MainActivity.class);
                    startActivity(mainActivity);
                    finish();

                }

                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });
    }

            @Override
            public void onBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

                    drawerLayout.closeDrawer(GravityCompat.START);

                }else {

                    super.onBackPressed();

                }
            }


            private void loadFragment(Fragment fragment) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,fragment);
                ft.commit();
            }











    // Slid view show function

    public void showimage(int img){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        luSlidFlipper.addView(imageView);
        luSlidFlipper.setFlipInterval(1000);
        luSlidFlipper.setAutoStart(true);

        luSlidFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        luSlidFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }




    // logout Button add


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // java file inflate done

        getMenuInflater().inflate(R.menu.menu_singout,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // user when sing out menu click

        if(item.getItemId() == R.id.singOutMenuId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }
}