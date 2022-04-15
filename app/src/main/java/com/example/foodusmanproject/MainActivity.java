package com.example.foodusmanproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodusmanproject.Adapters.MainAdapter;
import com.example.foodusmanproject.Models.MainModel;
import com.example.foodusmanproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    //     setContentView(R.layout.activity_main);
        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.burger,"Burger","5","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.boc,"Burger","6","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.burger2,"Burger","7","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.burger3,"Burger","8","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza1,"pizza1","9","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza2,"pizza2","10","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza3,"pizza3","11","Chicken burger with extra cheese"));
        MainAdapter adapter=new MainAdapter(list,this);
        binding.recycleview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recycleview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
