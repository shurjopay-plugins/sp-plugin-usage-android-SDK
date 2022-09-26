package com.shurjopay.sdk.v2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RequiredData(
  var username: String,
  var password: String,
  var prefix: String,
  var currency: String,
  var amount: Double,
  var order_id: String,
  var discount_amount: String?,
  var disc_percent: Int?,
  var customer_name: String,
  var customer_phone: String,
  var customer_email: String?,
  var customer_address: String,
  var customer_city: String,
  var customer_state: String?,
  var customer_postcode: String?,
  var customer_country: String?,
  var value1: String?,
  var value2: String?,
  var value3: String?,
  var value4: String?
) : Parcelable
