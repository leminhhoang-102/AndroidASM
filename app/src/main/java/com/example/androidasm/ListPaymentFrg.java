package com.example.androidasm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ListPaymentFrg extends Fragment implements View.OnClickListener {
    private Context mContext;
    private List<Payment> listPayment;
    private LinearLayout lnListPayment;
    private int indexSelected = -1;
    private OnMainActCallback callback;

    public void setCallback(OnMainActCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.frg_list_payment, container, false);
        initViews(viewRoot);
        return viewRoot;
    }


    private void initViews(View viewRoot) {
        initData();
        lnListPayment = viewRoot.findViewById(R.id.ln_list_payment);
        lnListPayment.removeAllViews();

        for (int i = 0; i < listPayment.size(); i++) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_payment, lnListPayment, false);
            TextView tvPrice = itemView.findViewById(R.id.tv_price);
            TextView tvName = itemView.findViewById(R.id.tv_name);
            tvPrice.setText(listPayment.get(i).getMoney());
            tvName.setText(listPayment.get(i).getName());

            lnListPayment.addView(itemView);
            itemView.setTag(listPayment.get(i));
            itemView.setOnClickListener(this);
        }

        if (indexSelected != -1) {
            lnListPayment.getChildAt(indexSelected).setBackgroundResource(R.color.design_default_color_secondary);
        }
    }

    private void initData() {
        listPayment = new ArrayList<>();
        listPayment.add(new Payment("tien net" , "nhieu","100.000","10/9/2021",new Category("giai tri")));
        listPayment.add(new Payment("tien rau" , "it","10.000","12/9/2021",new Category("an")));
        listPayment.add(new Payment("tien nuoc" , "nhieu","200.000","15/9/2021",new Category("sinh hoat")));
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ln_item) {
            //Toast.makeText(mContext,((ContactEntity) view.getTag()).getName(), Toast.LENGTH_SHORT).show();
            for (int i = 0; i < lnListPayment.getChildCount(); i++) {
                lnListPayment.getChildAt(i).setBackgroundResource(R.color.white);
            }
            view.setBackgroundResource(R.color.design_default_color_secondary);
            callback.showDetailPayment((Payment) view.getTag());
            indexSelected = listPayment.indexOf((Payment) view.getTag());
        }
    }
}
