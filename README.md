### shurjoPay(V2) Android SDK

# shurjoPay(V2) Android SDK Integration

[shurjoPay V2 Android SDK Integration](https://docs.google.com/document/d/1JLxmR0zgIqx1HEuxp_lJaljvWypby7n54F7z35HXO74/edit?usp=sharing)

### Integration documentation:

[shurjoPay Online Payment API Integration Guide](https://docs.google.com/document/d/19J4HE0j873nBJqcN-uRBYYAa_qBA3p1XSY-jy2fwvEE/edit?usp=sharing)


### Android Dependencies

```git_android_dependencies
implementation files("libs/sdk-name.aar")
implementation "com.squareup.retrofit2:retrofit:version"
implementation "com.squareup.retrofit2:converter-gson:version"
implementation "com.squareup.retrofit2:converter-scalars:version"
```

### Android AndroidManifest

```git_android_manifest_xml
<uses-permission android:name="android.permission.INTERNET"/>
```

### Request Data Model Setup:

```git_request_data_model_setup
// TODO request data model setup
val data = RequiredData(
    username,
    password,
    prefix,
    currency,
    amount,
    orderId,
    discountAmount,
    discPercent,
    customerName,
    customerPhone,
    customerEmail,
    customerAddress,
    customerCity,
    customerState,
    customerPostcode,
    customerCountry,
    returnUrl,
    cancelUrl,
    clientIp,
    value1,
    value2,
    value3,
    value4
)
```

### Response Listener Setup:


```git_response_listener_setup
// TODO response listener
object : PaymentResultListener {
    override fun onSuccess(errorSuccess: ErrorSuccess) {
        Log.d(TAG, "onSuccess: transactionInfo = ${errorSuccess.transactionInfo}")
        Toast.makeText(
            this@MainActivity, "onSuccess: transactionInfo = " +
                    errorSuccess.transactionInfo, Toast.LENGTH_LONG
        ).show()
    }
    //
    override fun onFailed(errorSuccess: ErrorSuccess) {
        Log.d(TAG, "onFailed: message = ${errorSuccess.message}")
        Toast.makeText(this@MainActivity, errorSuccess.message, Toast.LENGTH_SHORT).show()
    }
    //
    override fun onBackButtonListener(errorSuccess: ErrorSuccess): Boolean {
        return true
    }
}
```

### Payment Request Setup:


```git_payment_request_setup
// TODO payment request setup
ShurjoPaySDK.instance?.makePayment(
this,
Constants.SDK_TYPE_SANDBOX,
data,
object : PaymentResultListener {
    override fun onSuccess(errorSuccess: ErrorSuccess) {
        Log.d(TAG, "onSuccess: transactionInfo = ${errorSuccess.transactionInfo}")
        Toast.makeText(
            this@MainActivity, "onSuccess: transactionInfo = " +
                    errorSuccess.transactionInfo, Toast.LENGTH_LONG
        ).show()
    }

    override fun onFailed(errorSuccess: ErrorSuccess) {
        Log.d(TAG, "onFailed: message = ${errorSuccess.message}")
        Toast.makeText(this@MainActivity, errorSuccess.message, Toast.LENGTH_SHORT).show()
    }
})
```

shurjoPay(V2) Android SDK Integration