package com.shurjopay.sdk.v2.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

object NetworkManager {

  fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager =
      context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
      if (capabilities != null) {
        when {
          capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
//            Log.i(TAG, "NetworkCapabilities.TRANSPORT_CELLULAR")
            return true
          }
          capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
//            Log.i(TAG, "NetworkCapabilities.TRANSPORT_WIFI")
            return true
          }
          capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
//            Log.i(TAG, "NetworkCapabilities.TRANSPORT_ETHERNET")
            return true
          }
        }
      }
    return false
  }

  private const val TAG = "NetworkManager"
}
