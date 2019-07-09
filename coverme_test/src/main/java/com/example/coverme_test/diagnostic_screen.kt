package com.example.coverme_test

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.rm.freedrawview.FreeDrawView
import com.rm.freedrawview.PathDrawnListener

class DiagnosticScreen(context: Context) {

        companion object{


        fun drawGrid(context: Context, activity: Activity, numColumns: Int, numRows: Int, color: Int, fillColor: Int, strokeW: Float){

            var pixelGrid = PixelGridView(context)
            pixelGrid.numColumns = numColumns
            pixelGrid.numRows = numRows
            pixelGrid.fillColor = fillColor
            pixelGrid.backgrounColor = color
            pixelGrid.strokeW = strokeW
            activity.setContentView(pixelGrid)
            hideSystemUI(activity)

        }

        fun hideSystemUI(activity: Activity) {
            activity.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }

        fun imprimir() {
            Log.i("Porcentaje", porcenjate.toString())
        }
        }
    }
