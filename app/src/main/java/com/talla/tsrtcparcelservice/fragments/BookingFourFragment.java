package com.talla.tsrtcparcelservice.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talla.tsrtcparcelservice.R;
import com.talla.tsrtcparcelservice.activities.CreateShipmentActivity;
import com.talla.tsrtcparcelservice.activities.PlacedSucessfullyActivity;
import com.talla.tsrtcparcelservice.databinding.FragmentBookingFourBinding;


public class BookingFourFragment extends Fragment {
    private FragmentBookingFourBinding binding;
    private CreateShipmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookingFourBinding.inflate(getLayoutInflater(), container, false);

        binding.payNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PlacedSucessfullyActivity.class);
                intent.putExtra("keyItem", "BookingFourFragment");
                startActivity(intent);
            }
        });


        return binding.getRoot();
    }


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = (CreateShipmentActivity) activity;
    }

}