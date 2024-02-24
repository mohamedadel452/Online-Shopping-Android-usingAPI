package com.example.finalproject_intern.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.finalproject_intern.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Notivigation extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView  man;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notivigation);



        man=findViewById(R.id.man);
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notivigation.this,Profile.class));
            }
        });
        bottomNavigationView =findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.navigation);
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
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;}
                    case R.id.navigation:{

                        return true;}
                }
                return false;
            }
        });
    }
}