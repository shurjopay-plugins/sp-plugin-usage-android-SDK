package com.sm.shurjopaykotlintest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.shurjopay.sdk.v2.model.ErrorSuccess;
import com.shurjopay.sdk.v2.model.RequiredData;
import com.shurjopay.sdk.v2.payment.PaymentResultListener;
import com.shurjopay.sdk.v2.payment.ShurjoPaySDK;
import com.shurjopay.sdk.v2.utils.Constants;
import com.sm.shurjopaykotlintest.data.GetData;
import com.sm.shurjopaykotlintest.databinding.ActivityPaymentJavaBinding;

import java.util.Random;

public class PaymentJavaActivity extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private TextInputEditText sysInTextPayment;
    private Button sysBtnPayment;
    private ActivityPaymentJavaBinding binding;
    private RequiredData requiredData;

    //
    private Double price = 0.0;
    private final static String TAG = "PaymentJavaActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        context = this;
        binding = ActivityPaymentJavaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        binding.sysBtnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.sysInTextPayment.getText() == null) {
                    Toast.makeText(context, "Payment can't be null or empty", Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                price = Double.parseDouble(binding.sysInTextPayment.getText().toString());
                makePayment();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void makePayment() {
        requiredData = new GetData().getDataDefault();
        //
        ShurjoPaySDK.Companion.getInstance().makePayment(
                this,
                Constants.SDK_TYPE_LIVE,
                requiredData,
                new PaymentResultListener() {
                    @Override
                    public void onSuccess(@NonNull ErrorSuccess errorSuccess) {
                        Toast.makeText(
                                context,
                                "onSuccess: transactionInfo = " + errorSuccess.getTransactionInfo(),
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    @Override
                    public void onFailed(@NonNull ErrorSuccess errorSuccess) {
                        Toast.makeText(
                                context,
                                "onFailed: transactionInfo = " + errorSuccess.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    @Override
                    public boolean onBackButtonListener(@NonNull ErrorSuccess errorSuccess) {
                        return false;
                    }
                }
        );
    }
}