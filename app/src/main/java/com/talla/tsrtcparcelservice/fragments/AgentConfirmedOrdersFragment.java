package com.talla.tsrtcparcelservice.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talla.tsrtcparcelservice.R;
import com.talla.tsrtcparcelservice.databinding.FragmentAgentConfirmedOrdersBinding;


public class AgentConfirmedOrdersFragment extends Fragment {
    private FragmentAgentConfirmedOrdersBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAgentConfirmedOrdersBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

}