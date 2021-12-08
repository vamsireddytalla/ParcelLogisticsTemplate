package com.talla.tsrtcparcelservice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.talla.tsrtcparcelservice.adapters.AgentVewPagerAdapter;
import com.talla.tsrtcparcelservice.databinding.ActivityOrderDeliverBinding;
import com.talla.tsrtcparcelservice.databinding.DeliveryTabLayoutBinding;
import com.talla.tsrtcparcelservice.databinding.TabLayoutAgentBinding;
import com.talla.tsrtcparcelservice.fragments.DeliverOrdersFragment;
import com.talla.tsrtcparcelservice.fragments.DeliveredOrderFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderDeliverActivity extends AppCompatActivity
{
    private ActivityOrderDeliverBinding binding;
    private DeliveryTabLayoutBinding deliveryTabLayoutBinding;
    private AgentVewPagerAdapter vewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDeliverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        deliveryTabLayoutBinding=DeliveryTabLayoutBinding.bind(binding.getRoot());
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new DeliverOrdersFragment());
        fragmentList.add(new DeliveredOrderFragment());
        vewPagerAdapter=new AgentVewPagerAdapter(getSupportFragmentManager(),fragmentList,deliveryTabLayoutBinding.agentTabLayout.getTabCount());
        deliveryTabLayoutBinding.agentOrdersViewPager.setAdapter(vewPagerAdapter);
        deliveryTabLayoutBinding.agentOrdersViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(deliveryTabLayoutBinding.agentTabLayout));
        deliveryTabLayoutBinding.agentTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                deliveryTabLayoutBinding.agentOrdersViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}