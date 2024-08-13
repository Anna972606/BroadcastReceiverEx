package com.example.broadcastreceiversexample

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

object ListenerWifiLiveData : MutableLiveData<Int?>() {

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in Int?>) {
        super.observe(owner, Observer { data ->
            if (data == null) return@Observer
            observer.onChanged(data)
            value = null
        })
    }

    fun postEvent(data: Int) {
        postValue(data)
    }
}