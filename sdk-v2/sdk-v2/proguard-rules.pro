# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#-keep class com.shurjopay.sdk.v2.model.RequiredData.**
#-keepclassmembers class com.shurjopay.sdk.v2.model.RequiredData {*;}
#-keep class com.shurjopay.sdk.v2.model.TransactionInfo.**
#-keepclassmembers class com.shurjopay.sdk.v2.model.TransactionInfo {*;}
#-keep class com.shurjopay.sdk.v2.payment.ShurjoPaySDK.**
#-keepclassmembers class com.shurjopay.sdk.v2.payment.ShurjoPaySDK {*;}
#-keep class com.shurjopay.sdk.v2.payment.PaymentResultListener.**
#-keepclassmembers class com.shurjopay.sdk.v2.payment.PaymentResultListener {*;}
#-keep class com.shurjopay.sdk.v2.utils.ConstantsKt.**
#-keepclassmembers class com.shurjopay.sdk.v2.utils.ConstantsKt {*;}


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


-keep,allowobfuscation public class com.shurjopay.sdk.v2.model.** { public protected *; }
-keep,allowobfuscation public class com.shurjopay.sdk.v2.payment.** { public protected *; }
-keep,allowobfuscation public class com.shurjopay.sdk.v2.utils.** { public protected *; }
