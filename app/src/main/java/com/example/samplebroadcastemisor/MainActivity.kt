package com.example.samplebroadcastemisor

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.samplebroadcastemisor.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private var TAG = "Emisor"
    private var EXTRA_MOON_PHASE = "com.example.samplebroadcastemisor"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val btnSend = binding.btnSendMessage
        val txtMessage = binding.txtMessage

        btnSend.setOnClickListener {
            val mensaje = txtMessage.text.toString()
            sendMessage(mensaje)
            Log.d(TAG, "Se hizo click")
        }
    }

    fun sendMessage(mensaje: String) {
        val intent = Intent()
        intent.setComponent(ComponentName("com.example.samplebroadcastreceptor", "com.example.samplebroadcastreceptor.MoonBroadcastReceptor"))
        intent.setAction(EXTRA_MOON_PHASE)
        intent.putExtra(EXTRA_MOON_PHASE, mensaje)

        sendBroadcast(intent)
        Log.d(TAG, "Mensaje enviado")
    }
}