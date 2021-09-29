package com.example.androidasm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener, OnMainActCallback {

    private ImageView ivList, ivNew;
    private ListPaymentFrg listPaymentFrg;
    private DetailPaymentFrg detailPaymentFrg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {

        ivList = findViewById(R.id.iv_list);
        ivNew = findViewById(R.id.iv_new);
        changeTab(ivList, ivNew);


        ivNew.setOnClickListener(this);
        ivList.setOnClickListener( this);
        listPaymentFrg = new ListPaymentFrg();
        detailPaymentFrg = new DetailPaymentFrg();
        listPaymentFrg.setCallback(this);

        showListPayment();
    }

    private void showListPayment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, listPaymentFrg, listPaymentFrg.getClass().getName())
                .commit();
    }

    private void showDetailPayment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, detailPaymentFrg, detailPaymentFrg.getClass().getName())
                .commit();
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_list) {
            changeTab(ivList, ivNew);
            showListPayment();
        } else if (view.getId() == R.id.iv_new) {
            changeTab(ivNew, ivList);
            showDetailPayment();
        }
    }
    private void changeTab(ImageView selectTab, ImageView unselectTab) {
        selectTab.setBackgroundResource(R.color.white);
        selectTab.setColorFilter(ContextCompat.getColor(this, R.color.design_default_color_primary),
                android.graphics.PorterDuff.Mode.SRC_IN);
        unselectTab.setBackgroundResource(R.color.design_default_color_primary);
        unselectTab.setColorFilter(ContextCompat.getColor(this, R.color.white),
                android.graphics.PorterDuff.Mode.SRC_IN);
    }
    @Override
    public void showDetailPayment(Payment payment) {
        detailPaymentFrg.setPayment(payment);
        showDetailPayment();
    }
}