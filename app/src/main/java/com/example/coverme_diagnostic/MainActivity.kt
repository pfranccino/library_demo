package com.example.coverme_diagnostic


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.coverme_test.diagnostic_screen
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnTestScreen.setOnClickListener {
            var intent = Intent(this,ScreenActivity::class.java)
            finish()
            startActivity(intent)

        }


    }


  /*  */
}























    //strokeW es el ancho de la linea
    //backgroundColor
    //Fill_strokeColor


    //Agregar a documentacion que es necesario sobreescribir el metodo onResume para seguir ocultando  barras para navegacion




