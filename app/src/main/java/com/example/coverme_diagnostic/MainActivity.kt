package com.example.coverme_diagnostic


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.Nullable
import com.example.coverme_test.DiagnosticScreen
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {

        var diagnostic = DiagnosticScreen(this)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diagnostic.drawGrid(this, this, 20, 40 , Color.RED, Color.GREEN , 2.0F)


        Log.e("PorcentajeAc", diagnostic.imprimir().toString())



    }


    //strokeW es el ancho de la linea
    //backgroundColor
    //Fill_strokeColor


    //Agregar a documentacion que es necesario sobreescribir el metodo onResume para seguir ocultando  barras para navegacion

    override fun onResume() {
        super.onResume()


    }









}


