package com.example.cantinaunitbv;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class pas2 extends AppCompatActivity {

    TextView text21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pas2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text21 = findViewById(R.id.text21);
        LinearLayout linearLayout = findViewById(R.id.buna);

        for(int i = 0; i < 5; i++) {
            String aux = getIntent().getStringExtra("mancare" + i);
            String aux1 = getIntent().getStringExtra("cantitate" + i);
            if(Integer.valueOf(aux1) > 0) {
                TextView textView1 = new TextView((this));

                textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textView1.setText(aux + " x " + aux1);
                linearLayout.addView(textView1);
            }
        }

        String total = getIntent().getStringExtra("total");

        text21.setText("Total: " + total + " LEI");

    }
}
