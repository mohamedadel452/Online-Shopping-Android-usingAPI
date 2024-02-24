package com.example.finalproject_intern.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject_intern.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        button=findViewById(R.id.backtologin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,LoginAndSignup.class));
            }
        });


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.cart:{

                        startActivity(new Intent(getApplicationContext(),Chart.class));
                        overridePendingTransition(0,0);
                        return true;}
                    case R.id.home:{
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;}
                    case R.id.profile:{
                        return true;}
                    case R.id.navigation:{
                        startActivity(new Intent(getApplicationContext(),Notivigation.class));
                        overridePendingTransition(0,0);
                        return true;}
                }
                return false;
            }
        });
//        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.cart: {
//                        startActivity(new Intent(getApplicationContext(), Chart.class));
//                        overridePendingTransition(0, 0);
//                        break;
//                    }
//                    case R.id.home: {
//                        startActivity(new Intent(getApplicationContext(), Home.class));
//                        overridePendingTransition(0, 0);
//                        break;
//                    }
//                    case R.id.profile: {
//
//                        break;
//                    }
//                    case R.id.navigation: {
//                        startActivity(new Intent(getApplicationContext(), Notivigation.class));
//                        overridePendingTransition(0, 0);
//                        break;
//                    }
//                }
//            }
//
//        });
    }}