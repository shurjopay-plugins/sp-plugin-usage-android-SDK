#-keep class com.shurjopay.sdk.v2.model.*
#-keep class com.shurjopay.sdk.v2.payment.*
#-keep class com.shurjopay.sdk.v2.utils.*
#
#-keepclassmembers class com.shurjopay.sdk.v2.payment.PaymentResultListener {*;}
#-keepclassmembers class com.shurjopay.sdk.v2.payment.PaymentActivity {*;}
#
#-keepclassmembers class com.shurjopay.sdk.v2.payment.ShurjoPaySDK {
#    public static ** Companion;
#}
#
#-keepclassmembers class com.shurjopay.sdk.v2.utils.Constants {
#    public static ** Companion;
#}