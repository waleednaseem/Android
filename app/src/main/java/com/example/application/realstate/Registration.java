package com.example.application.realstate;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    Button Reg;
    EditText Remail,Rpass;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Reg=(Button)findViewById(R.id.Registration);
        Remail=(EditText) findViewById(R.id.Remail);
        Rpass=(EditText) findViewById(R.id.Rpass);

        firebaseAuth = FirebaseAuth.getInstance();
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }


        });
    }
    private void userRegister() {
        String email=Remail.getText().toString();
        String pass=Rpass.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Registration.this,"Registration succeed",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Registration.this, "unsuccesfull try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
