package com.shurjopay.sdk.v2.networking

import com.shurjopay.sdk.v2.model.CheckoutRequest
import com.shurjopay.sdk.v2.model.CheckoutResponse
import com.shurjopay.sdk.v2.model.Token
import com.shurjopay.sdk.v2.model.TransactionInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

  //////////////////// POST ///////////////////

  @POST("get_token")
  fun getToken(
    @Body token: Token
  ): Call<Token>

  @POST("secret-pay")
  fun checkout(
    @Header("Authorization") token: String,
    @Body checkoutRequest: CheckoutRequest
  ): Call<CheckoutResponse>

  @POST("verification")
  fun verify(
    @Header("Authorization") token: String,
    @Body transactionInfo: TransactionInfo
  ): Call<List<TransactionInfo>>
}