package com.shurjopay.sdk.v2.payment

import com.shurjopay.sdk.v2.model.TransactionInfo

interface PaymentResultListener {
  fun onSuccess(transactionInfo: TransactionInfo?)
  fun onFailed(message: String?)
}