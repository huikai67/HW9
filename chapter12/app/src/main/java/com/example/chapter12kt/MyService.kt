package com.example.chapter12kt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()


            GlobalScope.launch {
                try {
                    delay(5000L)
                    val intent = Intent(this@MyService, SecActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }


    }
    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        return START_NOT_STICKY //Service 終止後不再重啟
    }

    override fun onBind(intent: Intent): IBinder? = null
}