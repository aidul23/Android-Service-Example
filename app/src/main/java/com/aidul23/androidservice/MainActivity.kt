package com.aidul23.androidservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startButton: Button = findViewById(R.id.buttonStart)
        var stopButton: Button = findViewById(R.id.buttonStop)
        var sendButton: Button = findViewById(R.id.buttonSendData)
        var text: TextView = findViewById(R.id.textView)
        var editText: EditText = findViewById(R.id.editTextTextPersonName)

        //This one is for IntentService
//        startButton.setOnClickListener {
//            Intent(this, MyIntentService::class.java).also {
//                startService(it)
//                text.text = "Service Running"
//            }
//        }
//
//        stopButton.setOnClickListener {
//            MyIntentService.stopService()
//            text.text = "Service Stopped"
//        }

        startButton.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                text.text = "Service Running"
            }
        }

        stopButton.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                text.text = "Service Stopped"
            }
        }

        sendButton.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = editText.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                stopService(it)
            }
        }
    }
}