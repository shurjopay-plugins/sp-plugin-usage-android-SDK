

# Latest Version:

[![stars](https://img.shields.io/static/v1?label=SDK&message=v2.1.7&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK)
[![license](https://custom-icon-badges.herokuapp.com/github/license/denvercoder1/custom-icon-badges?logo=repo)](https://github.com/rzrasel/custom-icon-badges/blob/main/LICENSE?rgh-link-date=2021-08-09T18%3A10%3A26Z "license MIT")


Download the latest [![stars](https://img.shields.io/static/v1?label=SDK&message=v2.1.7&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK)

# shurjoPay(V2) Android SDK Integration

[shurjoPay V2 Android SDK Integration](https://docs.google.com/document/d/1JLxmR0zgIqx1HEuxp_lJaljvWypby7n54F7z35HXO74/edit?usp=sharing)

### Integration documentation:

[shurjoPay Online Payment API Integration Guide](https://docs.google.com/document/d/19J4HE0j873nBJqcN-uRBYYAa_qBA3p1XSY-jy2fwvEE/edit?usp=sharing)


# Integration and Installation

Download the latest [![stars](https://img.shields.io/static/v1?label=SDK&message=v2.1.7&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK) `SDK` from this github and put it in the <kbd>app/libs</kbd> folder. And add `dependencies` to the `app-level` <kbd>build.gradle</kbd> file.

# How To Integrate shurjoPay(V2) Android SDK (Kotlin)

### Android Dependencies

```git_android_dependencies
implementation files("libs/sdk-name.aar")
implementation "com.squareup.retrofit2:retrofit:version"
implementation "com.squareup.retrofit2:converter-gson:version"
implementation "com.squareup.retrofit2:converter-scalars:version"
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
    override fun onSuccess(errorSuccess: ErrorSuccess) {
        Toast.makeText(
            context,
            "onSuccess: transactionInfo = " + errorSuccess.transactionInfo,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onFailed(errorSuccess: ErrorSuccess) {
        Toast.makeText(
            context,
            "onFailed: transactionInfo = " + errorSuccess.message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBackButtonListener(errorSuccess: ErrorSuccess): Boolean {
        return false
    }
}
```

Old version

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
        Toast.makeText(
            context,
            "onSuccess: transactionInfo = " + errorSuccess.transactionInfo,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onFailed(errorSuccess: ErrorSuccess) {
        Toast.makeText(
            context,
            "onFailed: transactionInfo = " + errorSuccess.message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBackButtonListener(errorSuccess: ErrorSuccess): Boolean {
        return false
    }
})
```

Old version

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

# How To Integrate shurjoPay(V2) Android SDK (Java)

### Request Data Model Setup:

```git_request_data_model_setup
// TODO request data model setup
RequiredData data = new RequiredData(
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
);
```

### Response Listener Setup:

```git_response_listener_setup
// TODO response listener
new PaymentResultListener() {
    @Override
    public void onSuccess(@NonNull ErrorSuccess errorSuccess) {
        Toast.makeText(
                context,
                "onSuccess: transactionInfo = " + errorSuccess.getTransactionInfo(),
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    public void onFailed(@NonNull ErrorSuccess errorSuccess) {
        Toast.makeText(
                context,
                "onFailed: transactionInfo = " + errorSuccess.getMessage(),
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    public boolean onBackButtonListener(@NonNull ErrorSuccess errorSuccess) {
        return false;
    }
}
```

### Payment Request Setup:

```git_payment_request_setup
// TODO payment request setup
ShurjoPaySDK.Companion.getInstance().makePayment(
        this,
        Constants.SDK_TYPE_LIVE,
        data,
        new PaymentResultListener() {
            @Override
            public void onSuccess(@NonNull ErrorSuccess errorSuccess) {
                Toast.makeText(
                        context,
                        "onSuccess: transactionInfo = " + errorSuccess.getTransactionInfo(),
                        Toast.LENGTH_LONG
                ).show();
            }

            @Override
            public void onFailed(@NonNull ErrorSuccess errorSuccess) {
                Toast.makeText(
                        context,
                        "onFailed: transactionInfo = " + errorSuccess.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }

            @Override
            public boolean onBackButtonListener(@NonNull ErrorSuccess errorSuccess) {
                return false;
            }
        }
);
```

shurjoPay SDK integration and installation
