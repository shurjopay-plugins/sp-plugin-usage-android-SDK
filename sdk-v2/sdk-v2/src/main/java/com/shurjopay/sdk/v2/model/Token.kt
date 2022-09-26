package com.shurjopay.sdk.v2.model


data class Token(
    var username: String,
    var password: String,
    var token: String?,
    var store_id: Int?,
    var execute_url: String?,
    var token_type: String?,
    var sp_code: Int?,
    var massage: String?,
    var expires_in: String?
)