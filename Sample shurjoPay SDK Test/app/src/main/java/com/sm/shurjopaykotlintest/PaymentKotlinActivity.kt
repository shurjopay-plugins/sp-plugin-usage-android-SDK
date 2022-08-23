package com.sm.shurjopaykotlintest

import android.R
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shurjopay.sdk.v2.model.ErrorSuccess
import com.shurjopay.sdk.v2.model.RequiredData
import com.shurjopay.sdk.v2.payment.PaymentResultListener
import com.shurjopay.sdk.v2.payment.ShurjoPaySDK
import com.shurjopay.sdk.v2.utils.Constants
import com.sm.shurjopaykotlintest.data.GetData
import com.sm.shurjopaykotlintest.databinding.ActivityPaymentKotlinBinding


class PaymentKotlinActivity : AppCompatActivity() {
    private lateinit var activity: Activity
    private lateinit var context: Context
    private lateinit var binding: ActivityPaymentKotlinBinding
    private lateinit var requiredData: RequiredData

    //
    private var price: Double = 0.0

    companion object {
        private const val TAG = "PaymentKotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        context = this
        binding = ActivityPaymentKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //
        //price = binding.sysInTextPayment.text.toString().toDouble()
        binding.sysBtnPayment.setOnClickListener {
            if (binding.sysInTextPayment.text == null) {
                Toast.makeText(context, "Payment can't be null or empty", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            price = binding.sysInTextPayment.text.toString().toDouble()
            makePayment()
        }
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.getItemId()) {
            R.id.home -> {
                finish()
               true
            }
            else -> super.onOptionsItemSelected(menuItem)
        }
    }

    private fun makePayment() {
        //val amount: Double = sysInTextPayment.text.toString().toDouble()
        requiredData = GetData().getDataDefault()
        //
        ShurjoPaySDK.instance?.makePayment(
            this,
            Constants.SDK_TYPE_LIVE,
            requiredData,
            object : PaymentResultListener {
                override fun onSuccess(errorSuccess: ErrorSuccess) {
                    Toast.makeText(
                        context,
                        "onSuccess: transactionInfo = " + errorSuccess.transactionInfo,
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailed(errorSuccess: ErrorSuccess) {
                    Toast.makeText(
                        context,
                        "onFailed: transactionInfo = " + errorSuccess.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onBackButtonListener(errorSuccess: ErrorSuccess): Boolean {
                    return false
                }
            })
    }
}