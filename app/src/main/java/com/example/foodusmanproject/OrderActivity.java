package com.example.foodusmanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodusmanproject.Adapters.OrderAdapter;
import com.example.foodusmanproject.Models.OrderModel;
import com.example.foodusmanproject.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper= new DBHelper(this);
        ArrayList<OrderModel> list =helper.getOrders();



        OrderAdapter adapter=new OrderAdapter(list,this);
        binding.orderRecycleView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecycleView.setLayoutManager(layoutManager);
    }
}