package com.example.cantinaunitbv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {
    private Button Butonul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        TextView text=(TextView)findViewById(R.id.textView);
        Butonul=(Button)findViewById(R.id.butonulspecial);
        Butonul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WelcomeScreen.this,Logare.class);
                startActivity(intent);
            }
        });

    }
}
