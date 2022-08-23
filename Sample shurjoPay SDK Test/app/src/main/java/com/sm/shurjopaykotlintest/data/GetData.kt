package com.sm.shurjopaykotlintest.data

import com.shurjopay.sdk.v2.model.RequiredData
import java.util.*

class GetData {
    public fun getDataDefault(): RequiredData = RequiredData(
        "username",
        "password",
        "prefix",
        "currency",
        1.0,
        "orderId",
        0.0,
        null,
        "customer_name",
        "customer_phone",
        "customerEmail",
        "customerAddress",
        "customerCity",
        "customerState",
        "customerPostcode",
        "customerCountry",
        null,
        null,
        null,
        null,
        null,
        null,
        null,
    )
}