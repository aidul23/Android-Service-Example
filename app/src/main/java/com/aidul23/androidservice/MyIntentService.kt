package com.aidul23.androidservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

/*
* Intent Service is automatically runs in a separate thread rather than running in a main thread.
* Intent Service is automatically stopped or killed when all the command of onHandleIntent function is executed.
* */

class MyIntentService: IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object{
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is stopping...")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntentService", "Service is running....")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

}