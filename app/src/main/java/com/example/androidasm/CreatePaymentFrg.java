package com.example.androidasm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class CreatePaymentFrg extends Fragment {

    private Context mContext;
    private Payment payment;
    private EditText edName;
    private EditText edDescription;
    private EditText edCategory;
    private EditText edPrice;
    private EditText edTime;
    private Button btnCreate;
    private List<Payment> list;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_payment_frg, container, false);

    }

}