package com.talla.tsrtcparcelservice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.talla.tsrtcparcelservice.adapters.AgentVewPagerAdapter;
import com.talla.tsrtcparcelservice.databinding.ActivityAgentBinding;
import com.talla.tsrtcparcelservice.databinding.TabLayoutAgentBinding;
import com.talla.tsrtcparcelservice.fragments.AgentConfirmedOrdersFragment;
import com.talla.tsrtcparcelservice.fragments.AgentNewOrdersFragment;
import com.talla.tsrtcparcelservice.fragments.DeliverOrdersFragment;

import java.util.ArrayList;
import java.util.List;

public class AgentActivity extends AppCompatActivity
{
    private ActivityAgentBinding binding;
    private AgentVewPagerAdapter vewPagerAdapter;
    private TabLayoutAgentBinding tabLayoutAgentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tabLayoutAgentBinding=TabLayoutAgentBinding.bind(binding.getRoot());
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new AgentNewOrdersFragment());
        fragmentList.add(new AgentConfirmedOrdersFragment());
        vewPagerAdapter=new AgentVewPagerAdapter(getSupportFragmentManager(),fragmentList,tabLayoutAgentBinding.agentTabLayout.getTabCount());
        tabLayoutAgentBinding.agentOrdersViewPager.setAdapter(vewPagerAdapter);
        tabLayoutAgentBinding.agentOrdersViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutAgentBinding.agentTabLayout));
        tabLayoutAgentBinding.agentTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayoutAgentBinding.agentOrdersViewPager.setCurrentItem(tab.getPosition());
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