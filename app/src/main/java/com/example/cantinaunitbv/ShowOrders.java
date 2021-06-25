package com.example.cantinaunitbv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowOrders extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://cantina-unitbv-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference root = database.getReference().child("order");
    MyAdapter_Orders myAdapter_orders;
    ArrayList<OrderHelperClass> list;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders);

        Intent intent = getIntent();
        email = intent.getStringExtra("Email");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myAdapter_orders = new MyAdapter_Orders(this, list);

        recyclerView.setAdapter(myAdapter_orders);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    OrderHelperClass orderHelperClass = dataSnapshot1.getValue(OrderHelperClass.class);

                    // Trebuie inlocuit mail-ul de aici cu mail-ul userului curent
                    if(orderHelperClass.email.equals(email)) {
                        list.add(orderHelperClass);
                    }
                }
                myAdapter_orders.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}