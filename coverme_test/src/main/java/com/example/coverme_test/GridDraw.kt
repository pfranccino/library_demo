package com.example.coverme_test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.*


class PixelGridView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {


    var numColumns: Int = 0
        set(numColumns) {
            field = numColumns
            calculateDimensions()
        }
    var numRows: Int = 0
        set(numRows) {
            field = numRows
            calculateDimensions()
        }

    var fillColor : Int = 0
    set(fillColor) {
        field = fillColor
        setColor()
    }

    var strokeW : Float = 0F
        set(strokeW) {
            field = strokeW
            setStrokeW()
        }

    var backgrounColor  : Int = 0
    private var count : Int = 0
    var porcenjate : Double = 0.0
    private var cellWidth: Double = 0.0
    private var cellHeight: Double = 0.0
    private val blackPaint = Paint()
    private var cellChecked: Array<BooleanArray>? = null

    init {
        blackPaint.style = Paint.Style.FILL_AND_STROKE
    }

    private fun getPorcentaje() : Double {
        return porcenjate
    }


    private fun setStrokeW(){
        blackPaint.strokeWidth = strokeW
    }

    private fun setColor(){
        blackPaint.color = fillColor
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        calculateDimensions()
    }

    private fun calculateDimensions() {
        if (this.numColumns < 1 || this.numRows < 1) {
            return
        }

        cellWidth = width / this.numColumns.toDouble()
        cellHeight = height / this.numRows.toDouble()
        cellChecked = Array(this.numColumns) { BooleanArray(this.numRows) }

        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(backgrounColor)

        if (this.numColumns == 0 || this.numRows == 0) {
            return
        }

        val width = width
        val height = height

        for (i in 0 until this.numColumns) {
            for (j in 0 until this.numRows) {
                if (cellChecked!![i][j]) {

                    canvas.drawRect(
                        (i * cellWidth).toFloat(), (j * cellHeight).toFloat(),
                        ((i + 1) * cellWidth).toFloat(), ((j + 1) * cellHeight).toFloat(),
                        blackPaint
                    )
                }
            }
        }

        for (i in 1 until this.numColumns) {
            canvas.drawLine((i * cellWidth).toFloat(), 0F, (i * cellWidth).toFloat(), height.toFloat(), blackPaint)
        }

        for (i in 1 until this.numRows) {
            canvas.drawLine(0F, (i * cellHeight).toFloat(), width.toFloat(), (i * cellHeight).toFloat(), blackPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_MOVE) {
            val column = (event.x / cellWidth).toInt()
            val row = (event.y / cellHeight).toInt()
            if ( column in 0 until numColumns && row in 0 until numRows && !cellChecked!![column][row] ){
                count++
                cellChecked!![column][row] = true
                porcenjate = ((count.toDouble() * 100)/(numColumns*numRows))
              //   Log.e("Porcentaje", porcenjate.toString())
            }
            invalidate()
        }
        return true
    }


}