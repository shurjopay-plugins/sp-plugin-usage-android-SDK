

# Latest Version:

[![stars](https://img.shields.io/static/v1?label=SDK&message=2.1.1&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK)
[![license](https://custom-icon-badges.herokuapp.com/github/license/denvercoder1/custom-icon-badges?logo=repo)](https://github.com/rzrasel/custom-icon-badges/blob/main/LICENSE?rgh-link-date=2021-08-09T18%3A10%3A26Z "license MIT")

# shurjoPay(V2) Android SDK Integration

[shurjoPay V2 Android SDK Integration](https://docs.google.com/document/d/1JLxmR0zgIqx1HEuxp_lJaljvWypby7n54F7z35HXO74/edit?usp=sharing)
 
### Integration documentation:

[shurjoPay Online Payment API Integration Guide](https://docs.google.com/document/d/19J4HE0j873nBJqcN-uRBYYAa_qBA3p1XSY-jy2fwvEE/edit?usp=sharing)


# Integration and Installation

Download the latest [![stars](https://img.shields.io/static/v1?label=SDK&message=2.1.1&color=red)](https://github.com/shurjoPay-Plugins/Android-SDK) `SDK` from this github and put it in the <kbd>app/libs</kbd> folder. And add `dependencies` to the `app-level` <kbd>build.gradle</kbd> file.

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