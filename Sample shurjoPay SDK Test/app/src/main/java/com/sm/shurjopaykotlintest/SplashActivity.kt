package com.sm.shurjopaykotlintest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    private lateinit var activity: Activity
    private lateinit var context: Context
    private val SPLASH_TIME_OUT = 2000
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        context = this
        setContentView(R.layout.splash_activity)
        //
        Handler(Looper.getMainLooper()).postDelayed({
            //val intent = Intent(this, PaymentActivity::class.java)
            val intent = Intent(context, PaymentOptionActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}