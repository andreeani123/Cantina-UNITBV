package com.example.cantinaunitbv;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

public class ScrollingActivity extends AppCompatActivity {

    FoodManager foodManager;

    RecyclerView recyclerView;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://cantina-unitbv-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference root = database.getReference().child("food");
    MyAdapter myAdapter;
    ArrayList<FoodHelperClass> list;
    ArrayList<String> items;
    ArrayList<String> itemNames;
    ArrayList<String> ids;
    String email;
    Button submitOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

//        foodManager = new FoodManager();
//
//        button = findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                foodManager.AddFood("Supa de pui", "Ingrediente: apa, sare, morcovi, ceapa, taitei, pui", 2.5);
//
//            }
//        });

        Intent intent = getIntent();
        email = intent.getStringExtra("Email");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        items = new ArrayList<>();

        ids = new ArrayList<>();

        itemNames = new ArrayList<>();

        myAdapter = new MyAdapter(this, list);

        recyclerView.setAdapter(myAdapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    FoodHelperClass foodHelperClass = snapshot.getValue(FoodHelperClass.class);
                    ids.add(snapshot.getKey());
                    list.add(foodHelperClass);
                }

                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submitOrder = findViewById(R.id.submitOrder);
        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double price = 0.0f;

                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).quantityText.getText().toString().equals("1")) {
                        items.add(ids.get(i));
                        itemNames.add(list.get(i).name);
                        price += list.get(i).price;
                    }
                }

                if(price > 0.0f) {
                    Intent i = new Intent(ScrollingActivity.this, OrderActivity.class);
                    i.putExtra("Price", price);
                    i.putExtra("Items", items);
                    i.putExtra("Names", itemNames);
                    i.putExtra("Email", email);
                    startActivity(i);
                }
                else {
                    TextView err = findViewById(R.id.err);

                    err.setText("Comanda nu poate fi goala!");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}