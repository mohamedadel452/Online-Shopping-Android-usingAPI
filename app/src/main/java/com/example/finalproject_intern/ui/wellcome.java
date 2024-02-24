package com.example.finalproject_intern.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.finalproject_intern.R;

public class wellcome extends AppCompatActivity {
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        Intent i = new Intent(this,LoginAndSignup.class);

        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                //do what you need here after 1sec
                startActivity(i);
            }
        },3000);
    }
    }
