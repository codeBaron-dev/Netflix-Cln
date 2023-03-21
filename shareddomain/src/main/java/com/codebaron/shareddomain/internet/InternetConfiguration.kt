package com.codebaron.shareddomain.internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.MutableLiveData
import com.codebaron.shareddomain.internet.model.InternetResponseObject

class InternetConfiguration {

    /**
     * @see <a href="https://developer.android.com/training/monitoring-device-state/connectivity-status-type">link</a>
     */

    fun internetConfiguration(context: Context): MutableLiveData<InternetStates<InternetResponseObject>> {
        val internetStates: MutableLiveData<InternetStates<InternetResponseObject>> = MutableLiveData()

        val networkRequest: NetworkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                internetStates.postValue(InternetStates.IsInternetAvailable(true))
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                val unMetered =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
                internetStates.postValue(
                    InternetStates.HasInternetStateChanged(true)
                )
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                internetStates.postValue(
                    InternetStates.IsInternetConnectionLost(true)
                )
            }
        }

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, networkCallback)

        return internetStates
    }
}