package com.shurjopay.sdk

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shurjopay.sdk.databinding.ActivityMainBinding
import com.shurjopay.sdk.v2.model.RequiredData
import com.shurjopay.sdk.v2.model.TransactionInfo
import com.shurjopay.sdk.v2.payment.PaymentResultListener
import com.shurjopay.sdk.v2.payment.ShurjoPaySDK
import com.shurjopay.sdk.v2.utils.Constants
import java.util.*

class MainActivity : AppCompatActivity() {

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
            "PPD",
            "BDT",
            binding.amountLayout.editText?.text.toString().toDouble(),
            "PPD" + Random().nextInt(1000000),
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
            null,
            null,
            null,
            null
        )

        ShurjoPaySDK.instance?.makePayment(
            this,
            Constants.SDK_TYPE_SANDBOX,
            data,
            object : PaymentResultListener {
                override fun onSuccess(transactionInfo: TransactionInfo?) {
                    Log.d(TAG, "onSuccess: transactionInfo = $transactionInfo")
                    Toast.makeText(
                        this@MainActivity, "onSuccess: transactionInfo = " +
                                transactionInfo, Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailed(message: String?) {
                    Log.d(TAG, "onFailed: message = $message")
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
            })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
