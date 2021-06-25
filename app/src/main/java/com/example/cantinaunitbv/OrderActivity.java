package com.example.cantinaunitbv;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.collection.LLRBNode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

public class OrderActivity extends AppCompatActivity {

    TextView price, confirmText;
    Button button, confirmOrder;
    ArrayList<String> items;
    ArrayList<String> itemNames;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Double pret = intent.getDoubleExtra("Price", 0.0f);
        email = intent.getStringExtra("Email");
        items = (ArrayList<String>) getIntent().getSerializableExtra("Items");
        itemNames = (ArrayList<String>) getIntent().getSerializableExtra("Names");

        price = findViewById(R.id.textView2);

        price.setText("Pretul total al comenzii este: " + pret.toString() + " LEI");

        OrderHelperClass orderHelperClass = new OrderHelperClass(email, items, itemNames, pret);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderActivity.this, MenuActivity.class);
                i.putExtra("Email", email);
                startActivity(i);
            }
        });

        confirmOrder = findViewById(R.id.confirmButton);
        confirmText = findViewById(R.id.confirmText);

        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderManager orderManager = new OrderManager();

                if(!orderManager.PlaceOrder(orderHelperClass)) {
                    confirmText.setTextColor(Color.GREEN);
                    confirmText.setText("Comanda plasata cu succes!");
                }
                else {
                    confirmText.setTextColor(Color.RED);
                    confirmText.setText("Comanda nu a fost plasata! Incercati din nou.");
                }


            }
        });

    }
}