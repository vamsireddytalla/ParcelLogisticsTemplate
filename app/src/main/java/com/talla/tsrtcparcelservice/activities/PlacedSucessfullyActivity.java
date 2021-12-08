package com.talla.tsrtcparcelservice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.talla.tsrtcparcelservice.databinding.ActivityPlacedSucessfullyBinding;

public class PlacedSucessfullyActivity extends AppCompatActivity {
    private ActivityPlacedSucessfullyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlacedSucessfullyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String keyValue = bundle.getString("keyItem");
            if (keyValue.equalsIgnoreCase("BookingFourFragment")) {
                binding.orderText.setText("Payment Done !" + "\n" + "Order Has Been Placed Sucessfully");
            }
        } else {
            binding.orderText.setText("Order Request Placed Sucessfully");
        }

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlacedSucessfullyActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

}