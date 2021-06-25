package com.example.cantinaunitbv;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;

public class OrderManager {

    public boolean PlaceOrder(OrderHelperClass orderHelperClass) {
        FirebaseDatabase database;
        DatabaseReference reference;

        database = FirebaseDatabase.getInstance("https://cantina-unitbv-default-rtdb.europe-west1.firebasedatabase.app/");
        UUID uuid = UUID.randomUUID();

        reference = database.getReference("order");

        return reference.child(String.valueOf(uuid)).setValue(orderHelperClass).isSuccessful();
    }
}
