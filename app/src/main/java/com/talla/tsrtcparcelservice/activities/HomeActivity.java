package com.talla.tsrtcparcelservice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.talla.tsrtcparcelservice.R;
import com.talla.tsrtcparcelservice.Utills.Util;
import com.talla.tsrtcparcelservice.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private ActionBarDrawerToggle toggle;
    private Intent gotoNextActivity;
    private View view;
    private TextView userNameProfile;
    private TextView openProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.toolBar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolBar, R.string.open, R.string.close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        toggle.syncState();
        binding.message.setSelected(true);

        //drawer  header logic
        view = binding.navigationView.getHeaderView(0);
        userNameProfile = view.findViewById(R.id.profileUserName);
        openProfile = view.findViewById(R.id.emailIdDash);
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_track_order:
                        Intent intent = new Intent(HomeActivity.this, TrackOrderActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.menu_orders:
                        Toast.makeText(HomeActivity.this, "Orders", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_settings:
                        Toast.makeText(HomeActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_logout:
                        Toast.makeText(HomeActivity.this, "LogOut", Toast.LENGTH_SHORT).show();
                        break;
                }
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        openProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });



        binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                Log.d("DRAWER_OPENED", "SLide");
                Util.hideKeyboard(HomeActivity.this);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Log.d("DRAWER_OPENED", "opened");
//                menuItemCheckManually();
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                Log.d("DRAWER_OPENED", "closed");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.d("DRAWER_OPENED", "state changed");
            }
        });

        binding.agentOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goo = new Intent(HomeActivity.this, AgentActivity.class);
                startActivity(goo);
            }
        });

        binding.deliveryAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goo = new Intent(HomeActivity.this, OrderDeliverActivity.class);
                startActivity(goo);
            }
        });

    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
            return;
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            HomeActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }


    public void createShipment(View view) {
        Intent intent = new Intent(this, CreateShipmentActivity.class);
        startActivity(intent);
    }

    public void deliveryOrders(View view) {
        openOrderActivity();
    }

    public void pendingOrders(View view) {
        openOrderActivity();
    }

    private void openOrderActivity() {
        Intent intent = new Intent(this, OrdersHistoryActivity.class);
        startActivity(intent);
    }

}