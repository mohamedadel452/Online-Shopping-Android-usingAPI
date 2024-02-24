package com.example.finalproject_intern.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject_intern.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginAndSignup extends AppCompatActivity {
    Button login,signup;
    Intent toslideshow,tologin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginandsignup);
        mAuth = FirebaseAuth.getInstance();
  login=findViewById(R.id.login);
  signup=findViewById(R.id.signup);

  toslideshow=new Intent(this,afterSignin.class);
  tologin=new Intent(this,Login.class);
  signup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          startActivity(toslideshow);
      }
  });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(tologin);
            }
        });


    }
    @Override

    public void onStart(){

        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        }
}