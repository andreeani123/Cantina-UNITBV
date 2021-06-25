package com.example.cantinaunitbv;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class FoodManager {

    public void AddFood(UUID uuid, String name, String description, Double price) {
        FoodHelperClass foodHelperClass = new FoodHelperClass(name, description, price);
        FirebaseDatabase database;
        DatabaseReference reference;

        database = FirebaseDatabase.getInstance("https://cantina-unitbv-default-rtdb.europe-west1.firebasedatabase.app/");
        UUID uuidOrder = UUID.randomUUID();
        reference = database.getReference("food");

        reference.child(String.valueOf(uuidOrder)).setValue(foodHelperClass);
    }
}
