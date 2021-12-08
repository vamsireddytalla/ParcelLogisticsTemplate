package com.talla.tsrtcparcelservice.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.talla.tsrtcparcelservice.fragments.AgentConfirmedOrdersFragment;
import com.talla.tsrtcparcelservice.fragments.AgentNewOrdersFragment;
import com.talla.tsrtcparcelservice.fragments.DeliverOrdersFragment;
import com.talla.tsrtcparcelservice.fragments.DeliveredOrderFragment;

public class DeliveryViewPagerAdapter extends FragmentPagerAdapter {
    private int totalTabs;

    public DeliveryViewPagerAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DeliverOrdersFragment();
            case 1:
                return new DeliveredOrderFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }}
