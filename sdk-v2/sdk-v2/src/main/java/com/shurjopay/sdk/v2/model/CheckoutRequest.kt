package com.shurjopay.sdk.v2.model

data class CheckoutRequest(
    var token: String,
    var store_id: Int,
    var prefix: String,
    var currency: String,
    var return_url: String?,
    var cancel_url: String?,
    var amount: Double,
    var order_id: String,
    var discount_amount: Double?,
    var disc_percent: Double?,
    var client_ip: String?,
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
)