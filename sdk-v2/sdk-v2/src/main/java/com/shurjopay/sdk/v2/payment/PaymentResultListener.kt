package com.shurjopay.sdk.v2.payment

import com.shurjopay.sdk.v2.model.ErrorSuccess

interface PaymentResultListener {
    fun onSuccess(errorSuccess: ErrorSuccess)
    fun onFailed(errorSuccess: ErrorSuccess)
    fun onBackButtonListener(errorSuccess: ErrorSuccess): Boolean
}