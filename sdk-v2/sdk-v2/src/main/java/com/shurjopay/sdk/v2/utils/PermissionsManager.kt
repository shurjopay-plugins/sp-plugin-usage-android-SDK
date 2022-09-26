package com.shurjopay.sdk.v2.utils

import android.Manifest
import android.content.Context
import com.shurjopay.sdk.v2.utils.PermissionsManager
import android.content.pm.PackageManager

object PermissionsManager {
  /**
   * Does User has internet permission
   *
   * @param context - the context
   * @return true if user has internet permission
   */
  fun doesUserHaveInternetPermission(context: Context): Boolean {
    return hasPermissions(context, Manifest.permission.INTERNET)
  }

  /**
   * Does User has Network state permission
   *
   * @param context - the context
   * @return true if user has network state permission
   */
  fun doesUserHaveNetworkStatePermission(context: Context): Boolean {
    return hasPermissions(context, Manifest.permission.ACCESS_NETWORK_STATE)
  }

  /**
   * Determines if the context calling has the required permission
   *
   * @param context    - the IPC context
   * @param permission - The permissions to check
   * @return true if the IPC has the granted permission
   */
  private fun hasPermission(context: Context, permission: String): Boolean {
    val res = context.checkCallingOrSelfPermission(permission)
    return res == PackageManager.PERMISSION_GRANTED
  }

  /**
   * Determines if the context calling has the required permissions
   *
   * @param context     - the IPC context
   * @param permissions - The permissions to check
   * @return true if the IPC has the granted permission
   */
  private fun hasPermissions(context: Context, vararg permissions: String): Boolean {
    var hasAllPermissions = true
    for (permission in permissions) {
      //return false instead of assigning, but with this you can log all permission values
      if (!hasPermission(context, permission)) {
        hasAllPermissions = false
      }
    }
    return hasAllPermissions
  }
}