package com.example.broadcastreceiversexample

import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.textViewState

class MainActivity : AppCompatActivity() {

    private val wifiStateReceiver = WifiStateReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiStateFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, wifiStateFilter)

        ListenerWifiLiveData.observe(this) {
            textViewState.text = if (it == WifiManager.WIFI_STATE_ENABLED) "ON" else "OFF"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiStateReceiver)
    }
}
