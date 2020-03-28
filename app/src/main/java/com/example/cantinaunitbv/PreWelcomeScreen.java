package com.example.cantinaunitbv;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PreWelcomeScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        new CountDownTimer(1500, 1000) {
            public void onFinish() {
                startActivity(new Intent(PreWelcomeScreen.this, WelcomeScreen.class));
            }
            public void onTick(long millisUntilFinished) {
            } }.start();

    }
}