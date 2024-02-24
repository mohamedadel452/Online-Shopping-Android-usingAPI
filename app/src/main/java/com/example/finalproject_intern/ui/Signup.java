package com.example.finalproject_intern.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalproject_intern.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    CheckBox checkBox;
    Button signup;
    Intent toSuccsessful;
    private TextInputLayout username;
    private TextInputLayout Email;
    private TextInputLayout passwoord;
    private TextInputLayout cpassword;
    // defining our own password pattern
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup = findViewById(R.id.signupinsignup);
        username = findViewById(R.id.usernameinsignup);
        Email = findViewById(R.id.emailinsignup);
        passwoord = findViewById(R.id.passwordinsignup);
        cpassword = findViewById(R.id.cpasswordinsignup);
        checkBox = findViewById(R.id.checkbox);

        toSuccsessful = new Intent(this, Succsessful.class);

        if(checkBox.isChecked()){
            signup.setClickable(true);
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();

            }
        });


    }
    private void Register()
    {
        String usernaame =  username.getEditText().getText().toString().trim();
        String user = Email.getEditText().getText().toString().trim();
        String pass = passwoord.getEditText().getText().toString().trim();
        String cpass=cpassword.getEditText().getText().toString().trim();
        if(!validateEmail(user)|!validatePassword(pass)|!validateusername(usernaame)){
            return;
        }

        else
        {
            if(validatecPassword(pass,cpass)){



            }}





    }



    private boolean validateusername(@NonNull String userInput) {


        // if the email input field is empty
        if (userInput.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }
    //
    private boolean validateEmail(String emailInput) {


        if (emailInput.isEmpty()) {
            Email.setError("Field can not be empty");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Email.setError("Please enter a valid email address");
            return false;
        } else {
            Email.setError(null);
            return true;
        }
    }

    private boolean validatePassword(String passwordInput ) {

        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.isEmpty()) {
            passwoord.setError("Field can not be empty");
            return false;
        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            passwoord.setError("Password is too weak");
            return false;
        } else {
            passwoord.setError(null);
            return true;
        }
    }

    private boolean validatecPassword(String passwoordInput,String cpasswordInput) {

        // if password field is empty
        // it will display error message "Field can not be empty"
        if (!cpasswordInput.equals(passwoordInput)) {
            passwoord.setError("The password is not the same ");
            cpassword.setError("The password is not the same ");
            return false;
        } else
            return true;
    }




//    public void confirmInput(View v) {
//        if (!validateEmail() | !validatePassword() ) {
//            return;
//        }
//        if (validatecPassword()) {
//            mAuth.createUserWithEmailAndPassword(Email.getEditText().getText().toString(),passwoord.getEditText().getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(Signup.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                        startActivity(toSuccsessful);
//
//                    }
//                    else{
//                        Toast.makeText(Signup.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//
//
//        }
//    }




    public void itemClicked( View v){
        if (checkBox.isChecked()) {

        }
    }
}