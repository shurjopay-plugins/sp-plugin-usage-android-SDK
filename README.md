

# Latest Version:

[![stars](https://img.shields.io/static/v1?label=SDK&message=2.1.1&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK)
[![license](https://custom-icon-badges.herokuapp.com/github/license/denvercoder1/custom-icon-badges?logo=repo)](https://github.com/rzrasel/custom-icon-badges/blob/main/LICENSE?rgh-link-date=2021-08-09T18%3A10%3A26Z "license MIT")

# shurjoPay(V2) Android SDK Integration

[shurjoPay V2 Android SDK Integration](https://docs.google.com/document/d/1JLxmR0zgIqx1HEuxp_lJaljvWypby7n54F7z35HXO74/edit?usp=sharing)
 
### Integration documentation:

[shurjoPay Online Payment API Integration Guide](https://docs.google.com/document/d/19J4HE0j873nBJqcN-uRBYYAa_qBA3p1XSY-jy2fwvEE/edit?usp=sharing)


# Integration and Installation

Download the latest [![stars](https://img.shields.io/static/v1?label=SDK&message=2.1.1&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK) `SDK` from this github and put it in the <kbd>app/libs</kbd> folder. And add `dependencies` to the `app-level` <kbd>build.gradle</kbd> file.


### Android Dependencies

```git_android_dependencies
implementation files("libs/sdk-name.aar")
implementation "com.squareup.retrofit2:retrofit:version"
implementation "com.squareup.retrofit2:converter-gson:version"
```

### Android Proguard

```git_android_proguard
-keep class com.shurjopay.sdk.v2.model.* {*;}
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
    override fun onSuccess(transactionInfo: TransactionInfo?) {
        Log.d(MainActivity.TAG, "onSuccess: transactionInfo = $transactionInfo")
        Toast.makeText(
            this@MainActivity, "onSuccess: transactionInfo = " +
                    transactionInfo, Toast.LENGTH_LONG
        ).show()
    }

    override fun onFailed(message: String?) {
        Log.d(MainActivity.TAG, "onFailed: message = $message")
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
```

### Payment Request Setup:

```git_payment_request_setup
// TODO payment request setup
ShurjoPaySDK.instance?.makePayment(this, Constants.SDK_TYPE_SANDBOX, data,
object : PaymentResultListener {
    override fun onSuccess(transactionInfo: TransactionInfo?) {
        Log.d(TAG, "onSuccess: transactionInfo = $transactionInfo")
        Toast.makeText(
            this@MainActivity, "onSuccess: transactionInfo = " +
                    transactionInfo, Toast.LENGTH_LONG
        ).show()
    }

    override fun onFailed(message: String?) {
        Log.d(TAG, "onFailed: message = $message")
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
})
```

shurjoPay SDK integration and installation