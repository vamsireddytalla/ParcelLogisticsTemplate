package com.talla.tsrtcparcelservice.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.talla.tsrtcparcelservice.R;
import com.talla.tsrtcparcelservice.activities.CreateShipmentActivity;
import com.talla.tsrtcparcelservice.databinding.FragmentBookOneBinding;
import com.talla.tsrtcparcelservice.databinding.FragmentBookingTwoBinding;

import java.util.ArrayList;
import java.util.List;


public class BookingTwoFragment extends Fragment {
    private FragmentBookingTwoBinding binding;
    private String doc_type = "Document";
    private CreateShipmentActivity activity;
    private boolean isAgentOrNot = false;

    public BookingTwoFragment(boolean isAgentOrNot) {
        this.isAgentOrNot = isAgentOrNot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookingTwoBinding.inflate(getLayoutInflater(), container, false);
           if (isAgentOrNot)
           {
               ((CreateShipmentActivity) getActivity()).setActionBarTitle("Update Shipment");
           }

        binding.docType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doc_type = "Document";
                binding.docType.setBackground(activity.getResources().getDrawable(R.drawable.doc_bg));
                binding.docTxt.setTextColor(activity.getResources().getColor(R.color.colorWhite));
                binding.nonDocTxt.setTextColor(activity.getResources().getColor(R.color.colorPrimary));
                binding.nonDocType.setBackgroundResource(0);
                binding.itemspinRoot.setVisibility(View.GONE);
                binding.weightSpinRoot.setVisibility(View.VISIBLE);
            }
        });
        binding.nonDocType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doc_type = "Non-Document";
                binding.nonDocType.setBackground(activity.getResources().getDrawable(R.drawable.doc_bg));
                binding.nonDocTxt.setTextColor(activity.getResources().getColor(R.color.colorWhite));
                binding.docTxt.setTextColor(activity.getResources().getColor(R.color.colorPrimary));
                binding.docType.setBackgroundResource(0);
                binding.itemspinRoot.setVisibility(View.VISIBLE);
                binding.weightSpinRoot.setVisibility(View.GONE);
            }
        });

        // item type like bags or boxes
        List<String> itemtypeList = new ArrayList<>();
        itemtypeList.add("Bag");
        itemtypeList.add("Box");
        ArrayAdapter<String> itemTypeAdapter = new ArrayAdapter<String>(activity, R.layout.custom_spinner, R.id.spinText, itemtypeList);
        binding.ItemTypeSpin.setAdapter(itemTypeAdapter);

        //doc weight in spinner
        List<String> doctypeList = new ArrayList<>();
        doctypeList.add("0-500 gms");
        doctypeList.add("500-1000 gms");
        doctypeList.add("above 1000 gms");
        ArrayAdapter<String> docTypeAdapter = new ArrayAdapter<String>(activity, R.layout.custom_spinner, R.id.spinText, doctypeList);
        binding.weightTypeSpin.setAdapter(docTypeAdapter);

        //continue button
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAgentOrNot) {
                    replaceFragment(new BookingFourFragment());
                } else {
                    replaceFragment(new BookigThreeFragment());
                }

            }
        });

        return binding.getRoot();
    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameContainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = (CreateShipmentActivity) activity;
    }


}