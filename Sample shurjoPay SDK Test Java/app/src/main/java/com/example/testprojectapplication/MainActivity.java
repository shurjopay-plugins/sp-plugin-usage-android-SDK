package com.example.testprojectapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testprojectapplication.databinding.ActivityMainBinding;
import com.shurjopay.sdk.v2.model.ErrorSuccess;
import com.shurjopay.sdk.v2.model.RequiredData;
import com.shurjopay.sdk.v2.payment.PaymentResultListener;
import com.shurjopay.sdk.v2.payment.ShurjoPaySDK;
import com.shurjopay.sdk.v2.utils.Constants;

import java.net.ContentHandler;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private ActivityMainBinding binding;
    //
    private RequiredData requiredData;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        binding.sysBtnPayment.setOnClickListener(view -> {
            makePayment();
        });
    }

    private void makePayment() {
        requiredData = getDataDefault();
        //
        ShurjoPaySDK.Companion.getInstance().makePayment(
                this,
                Constants.SDK_TYPE_SANDBOX,
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

    private RequiredData getDataDefault() {
        return new RequiredData(
                "username",
                "password",
                "prefix",
                "currency",
                1.0,
                "orderId",
                0.0,
                null,
                "customer_name",
                "customer_phone",
                "customerEmail",
                "customerAddress",
                "customerCity",
                "customerState",
                "customerPostcode",
                "customerCountry",
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
