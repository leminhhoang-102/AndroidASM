package com.example.androidasm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailPaymentFrg extends Fragment {
    private Context mContext;
    private Payment payment;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvCategory;
    private TextView tvPrice;
    private TextView tvTime;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemRoot = inflater.inflate(R.layout.frg_detail_payment, container, false);
        initViews(itemRoot);
        return itemRoot;
    }

    private void initViews(View itemRoot) {
        tvName = itemRoot.findViewById(R.id.tv_name);
        tvDescription = itemRoot.findViewById(R.id.tv_description);
        tvPrice = itemRoot.findViewById(R.id.tv_price);
        tvCategory = itemRoot.findViewById(R.id.tv_category);
        tvTime = itemRoot.findViewById(R.id.tv_time);

        if (payment != null) {
            tvName.setText(payment.getName());
            tvDescription.setText(payment.getDescription());
            tvPrice.setText(payment.getMoney());
            tvTime.setText(payment.getDateTime());
            tvCategory.setText(payment.getCategory().getName());
        }
    }
}
