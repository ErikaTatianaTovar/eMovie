package com.proyecto.emovie.application.ui.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object VerifyNetwork {

    fun isActiveNetwork(context: Context): Boolean {
        var isActiveNetwork = false
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.getNetworkCapabilities(cm.activeNetwork)?.run {
            isActiveNetwork = when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        return isActiveNetwork
    }
}