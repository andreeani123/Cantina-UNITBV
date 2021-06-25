package com.example.cantinaunitbv;

import android.content.Context;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<FoodHelperClass> mList;
    android.content.Context context;

    public MyAdapter(Context context, ArrayList<FoodHelperClass> mList) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FoodHelperClass foodHelperClass = mList.get(position);

        holder.name.setText(foodHelperClass.getName());
        holder.description.setText(foodHelperClass.getDescription());
        holder.price.setText(String.valueOf(foodHelperClass.getPrice()));

        foodHelperClass.quantityText = holder.cantitate;

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, description, price, cantitate;
        Button addButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            cantitate = itemView.findViewById(R.id.cantitate);
            addButton = itemView.findViewById(R.id.addButton);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cantitate.getText().equals("0")) {
                        cantitate.setText("1");
                    }
                    else {
                        cantitate.setText("0");
                    }
                }
            });
        }


    }

}
