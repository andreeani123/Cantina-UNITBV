package com.example.cantinaunitbv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Console;
import java.util.ArrayList;

public class MyAdapter_Orders extends RecyclerView.Adapter<MyAdapter_Orders.MyViewHolder> {

    ArrayList<OrderHelperClass> mList;
    Context context;

    public MyAdapter_Orders() {

    }

    public MyAdapter_Orders(Context context, ArrayList<OrderHelperClass> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        OrderHelperClass orderHelperClass = mList.get(position);

        holder.price.setText(Double.toString(orderHelperClass.price));

        String comanda = "";

        for (String word : orderHelperClass.itemNames) {
            comanda += word + ", ";
        }

        comanda = comanda.substring(0, comanda.length() - 2);

        holder.order.setText(comanda);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView price, order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.priceText);
            order = itemView.findViewById(R.id.itemsText);
        }
    }

}
