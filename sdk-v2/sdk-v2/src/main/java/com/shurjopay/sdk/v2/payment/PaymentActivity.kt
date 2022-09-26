package com.shurjopay.sdk.v2.payment

import android.app.ProgressDialog
import android.net.http.SslError
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.shurjopay.sdk.v2.databinding.ActivityPaymentBinding
import com.shurjopay.sdk.v2.model.*
import com.shurjopay.sdk.v2.networking.ApiClient
import com.shurjopay.sdk.v2.networking.ApiInterface
import com.shurjopay.sdk.v2.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    private lateinit var progressDialog: ProgressDialog

    private lateinit var sdkType: String
    private lateinit var data: RequiredData
    private var tokenResponse: Token? = null
    private var checkoutRequest: CheckoutRequest? = null
    private var checkoutResponse: CheckoutResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Wait...")
        progressDialog.setCancelable(false)

        sdkType = intent.getStringExtra(Constants.SDK_TYPE).toString()
        data = intent.getParcelableExtra(Constants.DATA)!!
        getToken()
    }

    private fun getToken() {
        showProgress()
        val token = Token(
            data.username, data.password, null, null, null,
            null, null, null, null
        )

        ApiClient().getApiClient(sdkType)?.create(ApiInterface::class.java)?.getToken(token)
            ?.enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    if (response.isSuccessful) {
                        tokenResponse = response.body()
                        getExecuteUrl()
                    }
                }
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    hideProgress()
                    ShurjoPaySDK.listener?.onFailed(
                        ErrorSuccess(
                            ErrorSuccess.ESType.HTTP_ERROR,
                            null,
                            Constants.PAYMENT_DECLINED,
                        )
                    )
                    finish()
                }
            })
    }

    private fun getExecuteUrl() {
        checkoutRequest = CheckoutRequest(
            tokenResponse?.token.toString(),
            tokenResponse?.store_id!!,
            data.prefix,
            data.currency,
            data.returnUrl,
            data.cancelUrl,
            data.amount,
            data.orderId,
            data.discountAmount,
            data.discPercent,
            data.clientIp,
            data.customerName,
            data.customerPhone,
            data.customerEmail,
            data.customerAddress,
            data.customerCity,
            data.customerState,
            data.customerPostcode,
            data.customerCountry,
            data.value1,
            data.value2,
            data.value3,
            data.value4
        )
        checkoutRequest!!.return_url = "${checkoutRequest!!.return_url}?return_url"
        checkoutRequest!!.cancel_url = "${checkoutRequest!!.cancel_url}?cancel_url"
        ApiClient().getApiClient(sdkType)?.create(ApiInterface::class.java)?.checkout(
            "Bearer " + tokenResponse?.token,
            checkoutRequest!!
        )?.enqueue(object : Callback<CheckoutResponse> {
            override fun onResponse(call: Call<CheckoutResponse>, response: Response<CheckoutResponse>) {
                hideProgress()
                if (response.isSuccessful) {
                    checkoutResponse = response.body()
                    setupWebView()
                }
            }
            override fun onFailure(call: Call<CheckoutResponse>, t: Throwable) {
                hideProgress()
                ShurjoPaySDK.listener?.onFailed(
                    ErrorSuccess(
                        ErrorSuccess.ESType.HTTP_ERROR,
                        null,
                        Constants.PAYMENT_DECLINED,
                    )
                )
                finish()
            }
        })
    }

    private fun setupWebView() {
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.loadsImagesAutomatically = true
        binding.webView.settings.domStorageEnabled = true
        binding.webView.loadUrl(checkoutResponse?.checkout_url.toString())
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//        Log.d(TAG, "shouldOverrideUrlLoading: url = $url")

                if (url.contains("cancel_url")) {
                    ShurjoPaySDK.listener?.onFailed(
                        ErrorSuccess(
                            ErrorSuccess.ESType.HTTP_ERROR,
                            null,
                            Constants.PAYMENT_CANCELLED,
                        )
                    )
                    finish()
                }
                if (url.contains("return_url") && url.contains("order_id")) {
                    verifyPayment()
                }
                return false
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }
        }
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                binding.progressBar.progress = newProgress
            }
        }
    }

    private fun verifyPayment() {
        showProgress()
        val transactionInfo = TransactionInfo(
            null,
            checkoutResponse?.sp_order_id!!,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )

        ApiClient().getApiClient(sdkType)?.create(ApiInterface::class.java)?.verify(
            "Bearer " + tokenResponse?.token,
            transactionInfo
        )?.enqueue(object : Callback<List<TransactionInfo>> {
            override fun onResponse(call: Call<List<TransactionInfo>>, response: Response<List<TransactionInfo>>) {
                hideProgress()
                if (response.isSuccessful) {
                    if (response.body()?.get(0)?.sp_code == 1000) {
                        ShurjoPaySDK.listener?.onSuccess(
                            ErrorSuccess(
                                ErrorSuccess.ESType.SUCCESS,
                                response.body()?.get(0),
                                "Payment successfully done",
                            )
                        )
                        finish()
                    }
                }
            }

            override fun onFailure(call: Call<List<TransactionInfo>>, t: Throwable) {
                hideProgress()
                ShurjoPaySDK.listener?.onFailed(
                    ErrorSuccess(
                        ErrorSuccess.ESType.HTTP_ERROR,
                        null,
                        Constants.PLEASE_CHECK_YOUR_PAYMENT,
                    )
                )
                finish()
            }
        })
    }

    private fun showProgress() {
        progressDialog.show()
    }

    private fun hideProgress() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    override fun onBackPressed() {
        ShurjoPaySDK.listener?.onFailed(
            ErrorSuccess(
                ErrorSuccess.ESType.HTTP_ERROR,
                null,
                Constants.PAYMENT_CANCELLED_BY_USER,
            )
        )
        super.onBackPressed()
    }

    companion object {
        private const val TAG = "PaymentActivity"
    }
}
