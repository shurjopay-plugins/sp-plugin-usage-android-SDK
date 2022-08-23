package com.sm.shurjopaykotlintest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sm.shurjopaykotlintest.databinding.ActivityPaymentOptionBinding

class PaymentOptionActivity : AppCompatActivity() {
    private lateinit var activity: Activity
    private lateinit var context: Context
    private lateinit var binding: ActivityPaymentOptionBinding

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        context = this
        binding = ActivityPaymentOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        binding.sysBtnJavaExample.setOnClickListener {
            val intent = Intent(context, PaymentJavaActivity::class.java)
            startActivity(intent)
        }
        binding.sysBtnKotlinExample.setOnClickListener {
            val intent = Intent(context, PaymentKotlinActivity::class.java)
            startActivity(intent)
        }
    }
}