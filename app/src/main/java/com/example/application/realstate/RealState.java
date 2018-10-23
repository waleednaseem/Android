package com.example.application.realstate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RealState extends Activity {

    Button Login ,LoginReg,Registration;
    EditText Name ,Password;
    FirebaseAuth firebaseAuth;
    FirebaseApp firebaseApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_state);


        Registration=(Button) findViewById(R.id.Registration);



    }

    public void Onreg(View v)
    {

        startActivity(new Intent(RealState.this,Registration.class));
    }

    public void onLogin(View view)
    {
        Name=(EditText) findViewById(R.id.Name);
        Password=(EditText) findViewById(R.id.Password);
        Login=(Button) findViewById(R.id.Loginbtn);
        String name=Name.getText().toString();
        String pass=Password.getText().toString();

            startActivity(new Intent(RealState.this,MainActivity.class));



    }

}

