package com.example.coverme_diagnostic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val intent = intent

        var message  = intent.getStringExtra("porcentage")

        Log.e("Porcentaje", message)
        textView2.text = message
    }
}
