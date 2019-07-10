package com.example.coverme_diagnostic


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.coverme_test.diagnostic_screen


class MainActivity : AppCompatActivity() {

    lateinit var dg: diagnostic_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        dg = diagnostic_screen(this)
        dg.draw(this, 10, 20)


    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        dg.onTouchItem(event)

        val porcentaje = dg.porcentage!!

        Log.i("Porcentage", "onTouchEvent: $porcentaje")

        return super.onTouchEvent(event)
    }
}
























    //strokeW es el ancho de la linea
    //backgroundColor
    //Fill_strokeColor


    //Agregar a documentacion que es necesario sobreescribir el metodo onResume para seguir ocultando  barras para navegacion




