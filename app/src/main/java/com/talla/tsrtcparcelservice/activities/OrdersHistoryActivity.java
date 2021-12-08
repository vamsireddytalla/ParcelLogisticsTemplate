package com.talla.tsrtcparcelservice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.talla.tsrtcparcelservice.databinding.ActivityOrdersHistoryBinding;

public class OrdersHistoryActivity extends AppCompatActivity {
    private ActivityOrdersHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.itemOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OrdersHistoryActivity.this,OrderDetailActivity.class);
                startActivity(intent);
            }
        });
        binding.itemTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OrdersHistoryActivity.this,OrderDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}