package com.shurjopay.sdk.v2.utils

import androidx.annotation.Keep

@Keep class Constants {
  @Keep companion object {
    const val SDK_TYPE = "sdk-type"
    const val SDK_TYPE_SANDBOX = "sandbox"
    const val SDK_TYPE_LIVE = "live"
    const val SDK_TYPE_IPN_SANDBOX = "ipn-sandbox"
    const val SDK_TYPE_IPN_LIVE = "ipn-live"
    const val BASE_URL_SANDBOX = "https://sandbox.shurjopayment.com/api/"
    const val BASE_URL_LIVE = "https://engine.shurjopayment.com/api/"
    const val BASE_URL_IPN_SANDBOX = "http://ipn.shurjotest.com/"
    const val BASE_URL_IPN_LIVE = "http://ipn.shurjopay.com/"
    const val USER_INPUT_ERROR = "User input error!"
    const val PAYMENT_CANCELLED = "Payment Cancelled!"
    const val PAYMENT_CANCELLED_BY_USER = "Payment Cancelled By User!"
    const val PAYMENT_DECLINED = "Payment has been declined from gateway!"
    const val PLEASE_CHECK_YOUR_PAYMENT = "Please Check Your Payment"
    const val BANK_TRANSACTION_FAILED = "Bank transaction failed!"
    const val NO_INTERNET_PERMISSION = "No internet permission is given!"
    const val NO_NETWORK_STATE_PERMISSION = "No network state permission is given!"
    const val NO_INTERNET_MESSAGE = "No internet connection! Please check your connection settings."
    const val INVALID_AMOUNT = "Invalid amount!"
    const val DATA = "data"
  }
}