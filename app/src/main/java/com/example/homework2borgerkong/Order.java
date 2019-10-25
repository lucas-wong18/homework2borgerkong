package com.example.homework2borgerkong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static TextView status;
    public static TextView itemCount;
    public Button clearOrder;
    public static TextView totalCost;
    public static ArrayList<MenuItem> menuOrder = new ArrayList<>();
    public static ArrayList<Double> menuCost = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();

        status = findViewById(R.id.status);
        itemCount = findViewById(R.id.itemCount);
        clearOrder = findViewById(R.id.clearOrder);
        totalCost = findViewById(R.id.totalCost);

        clearOrder.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (menuOrder.size() < 1){
                    Toast.makeText(Order.this, "There is nothing in your basket", Toast.LENGTH_SHORT).show();

                } else {
                    menuCost.clear();
                    menuOrder.clear();
                    startActivity(getIntent());
                    finish();
                }
            }
        });

        int items = menuOrder.size();
        itemCount.setText(items + " " + "items in basket");

        if (menuCost.size() < 1 || menuCost.size() < 1) {
            totalCost.setText("$0.00");
            status.setText("No items in basket");

        } else {
            status.setText("");
            recyclerView = findViewById(R.id.recyclerView2);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            OrderAdapter orderAdapter = new OrderAdapter();
            orderAdapter.setData(menuOrder);
            recyclerView.setAdapter(orderAdapter);
        }
    }
}
