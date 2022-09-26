package com.shurjopay.sdk.v2.payment

import android.app.Activity
import android.content.Intent
import com.shurjopay.sdk.v2.model.ErrorSuccess
import com.shurjopay.sdk.v2.model.RequiredData
import com.shurjopay.sdk.v2.utils.Constants
import com.shurjopay.sdk.v2.utils.NetworkManager.isInternetAvailable

class ShurjoPaySDK private constructor() {

    fun makePayment(
        activity: Activity, sdkType: String?, data: RequiredData?,
        resultListener: PaymentResultListener?
    ) {
        listener = resultListener
        if (!isInternetAvailable(activity)) {
            listener!!.onFailed(
                ErrorSuccess(
                    ErrorSuccess.ESType.INTERNET_ERROR,
                    null,
                    Constants.NO_INTERNET_MESSAGE
                )
            )
            return
        }
        val intent = Intent(activity, PaymentActivity::class.java)
        intent.putExtra(Constants.DATA, data)
        intent.putExtra(Constants.SDK_TYPE, sdkType)
        activity.startActivity(intent)
    }

    companion object {
        private var mInstance: ShurjoPaySDK? = ShurjoPaySDK()
        var listener: PaymentResultListener? = null
        val instance: ShurjoPaySDK?
            get() {
                if (mInstance == null) {
                    mInstance = ShurjoPaySDK()
                }
                return mInstance
            }
    }
}