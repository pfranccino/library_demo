package com.example.coverme_diagnostic

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import com.example.coverme_test.diagnostic_screen
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule

class ScreenActivity : AppCompatActivity() {

    lateinit var dg: diagnostic_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        dg = diagnostic_screen(this)
        dg.draw(this, 10, 20 , Color.GREEN, Color.CYAN)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        intent
        dg.onTouchItem(event)

        var porcentaje = dg.porcentage!!

        if (porcentaje>= 10.0){

        var intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("porcentage", porcentaje.toString())
            finish()
            startActivity(intent)

        }


        return super.onTouchEvent(event)
    }
}
