package com.example.cantinaunitbv;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Logare extends AppCompatActivity

{


    EditText txtEmail;
    EditText txtparola;
    private FirebaseAuth firebaseAuth;

    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logare);


        txtEmail=(EditText)findViewById(R.id.username);
        txtparola=(EditText)findViewById(R.id.password);
        Login=(Button)findViewById(R.id.login);

        firebaseAuth=FirebaseAuth.getInstance();







        Login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                String email=txtEmail.getText().toString().trim();
                String parola=txtparola.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Logare.this, "Introdu adresa de E-mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(parola))
                {
                    Toast.makeText(Logare.this, "Introdu parola", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,parola)
                        .addOnCompleteListener(Logare.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if(task.isSuccessful())
                                {
                                    startActivity(new Intent(getApplicationContext(),ScrollingActivity.class));
                                }
                                else
                                {
                                    Toast.makeText(Logare.this, "Datele introduse sunt gresite", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });



    }

}
