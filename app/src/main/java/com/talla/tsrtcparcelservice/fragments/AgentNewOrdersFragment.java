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
import com.talla.tsrtcparcelservice.activities.AgentActivity;
import com.talla.tsrtcparcelservice.activities.CreateShipmentActivity;
import com.talla.tsrtcparcelservice.databinding.FragmentAgentNewOrdersBinding;

public class AgentNewOrdersFragment extends Fragment {
    private FragmentAgentNewOrdersBinding binding;
    private AgentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAgentNewOrdersBinding.inflate(getLayoutInflater(), container, false);

        binding.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity,CreateShipmentActivity.class);
                intent.putExtra("classKey","AgentNewOrdersFragment");
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = (AgentActivity) activity;
    }
}