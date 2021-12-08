package com.talla.tsrtcparcelservice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.talla.tsrtcparcelservice.R;
import com.talla.tsrtcparcelservice.databinding.ActivityCreateShipmentBinding;
import com.talla.tsrtcparcelservice.fragments.BookOneFragment;
import com.talla.tsrtcparcelservice.fragments.BookingTwoFragment;

public class CreateShipmentActivity extends AppCompatActivity {
    private ActivityCreateShipmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateShipmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String className = bundle.getString("classKey");
            if (className.equalsIgnoreCase("AgentNewOrdersFragment")) {
                addFragment(new BookingTwoFragment(true));
            }
        } else {
            addFragment(new BookOneFragment());
        }
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameContainer, fragment);
        ft.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }


    public void setActionBarTitle(String titleText)
    {
        binding.tootlbarTitle.setText(titleText);
    }

}