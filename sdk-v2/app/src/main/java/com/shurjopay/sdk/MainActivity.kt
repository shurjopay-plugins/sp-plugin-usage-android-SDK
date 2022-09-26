package com.shurjopay.sdk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shurjopay.sdk.databinding.ActivityMainBinding
import com.shurjopay.sdk.v2.model.ErrorSuccess
import com.shurjopay.sdk.v2.model.RequiredData
import com.shurjopay.sdk.v2.payment.PaymentResultListener
import com.shurjopay.sdk.v2.payment.ShurjoPaySDK
import com.shurjopay.sdk.v2.utils.Constants
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener { pay() }
    }

    private fun pay() {
        val data = RequiredData(
            "sp_sandbox",
            "pyyk97hu&6u6",
            "NOK",
            "BDT",
            binding.amountLayout.editText?.text.toString().toDouble(),
            "NOK" + Random().nextInt(1000000),
            null,
            null,
            binding.nameLayout.editText?.text.toString(),
            binding.phoneLayout.editText?.text.toString(),
            null,
            binding.addressLayout.editText?.text.toString(),
            binding.cityLayout.editText?.text.toString(),
            null,
            null,
            null,
            "https://www.sandbox.shurjopayment.com/response",
            "https://www.sandbox.shurjopayment.com/response",
            "127.0.0.1",
            "value-of-1",
            "value-of-2",
            "value-of-3",
            "value-of-4"
        )

        ShurjoPaySDK.instance?.makePayment(
            this,
            Constants.SDK_TYPE_SANDBOX,
            data,
            object : PaymentResultListener {
                override fun onSuccess(errorSuccess: ErrorSuccess) {
                    Log.d(TAG, "onSuccess: debugMessage = ${errorSuccess.debugMessage}")
                }

                override fun onFailed(errorSuccess: ErrorSuccess) {
                    Log.d(TAG, "onFailed: debugMessage = ${errorSuccess.debugMessage}")
                }

                override fun onBackButtonListener(errorSuccess: ErrorSuccess): Boolean {
                    return true
                }
            })
    }
}
