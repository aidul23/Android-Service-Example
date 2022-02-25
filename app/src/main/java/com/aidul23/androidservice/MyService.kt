package com.aidul23.androidservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/*
* Service is not automatically runs in a separate thread rather than it runs in a main thread so it can freeze UI.
* Service can not be automatically stopped or killed. User need to stop it
* */

class MyService : Service() {

    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is running...")
    }
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data = intent?.getStringExtra("EXTRA_DATA")
        data?.let {
            Log.d(TAG, data)
        }

        Thread{
            while (true) {}
        }.start()

        return START_STICKY
    }

}