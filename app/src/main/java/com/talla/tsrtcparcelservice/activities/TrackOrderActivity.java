package com.talla.tsrtcparcelservice.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.talla.tsrtcparcelservice.Utills.CaptureActivity;
import com.talla.tsrtcparcelservice.databinding.ActivityTrackOrderBinding;

public class TrackOrderActivity extends AppCompatActivity {
    private ActivityTrackOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrackOrderActivity.this, OrderStatusActivity.class);
                startActivity(intent);
            }
        });

        binding.scanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(TrackOrderActivity.this);
                //set prompt text
                intentIntegrator.setPrompt("For Flash-Light Use Volume Up-Key");
                //set beep
                intentIntegrator.setBeepEnabled(true);
                //lock orientation
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(CaptureActivity.class);
                intentIntegrator.initiateScan();
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Initialize intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if (intentResult.getContents() != null) {
            //when result content is not null
            //initilize dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(TrackOrderActivity.this);
            builder.setTitle("Tracking Id ");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Intent intent = new Intent(TrackOrderActivity.this, OrderStatusActivity.class);
                    startActivity(intent);
                }
            });

            builder.show();
        }else {
            Toast.makeText(this, "OOPS you Didn't Scan Any thing", Toast.LENGTH_SHORT).show();
        }

    }

}