package com.example.coverme_test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class grid_draw extends View {

    private int numColumns, numRows;
    private Float cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private boolean[][] cellChecked;
    private int backgroundColors;
    private double count;
    private double porcentage;


    public grid_draw(Context context) {
        this(context, null);
    }

    public grid_draw(Context context, AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public int getBackgroundColors() {
        return backgroundColors;
    }

    public void setBackgroundColors(int backgroundColors) {
        this.backgroundColors = backgroundColors;
    }

    public void setColor(int color) {
        blackPaint.setColor(color);
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }


    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }




    public double getPorcentage() {
        return porcentage;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return;
        }
        cellWidth = getWidth() / Float.parseFloat(String.valueOf(numColumns));
        cellHeight = getHeight() / Float.parseFloat(String.valueOf(numRows));

        cellChecked = new boolean[numColumns][numRows];

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(getBackgroundColors());

        if (numColumns == 0 || numRows == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                if (cellChecked[i][j]) {

                    canvas.drawRect(i * cellWidth, j * cellHeight,
                            (i + 1) * cellWidth, (j + 1) * cellHeight,
                            blackPaint);
                }
            }
        }

        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, blackPaint);
        }

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, blackPaint);
        }
    }


    public void onSelect(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            int column = (int) (event.getX() / cellWidth);
            int row = (int) (event.getY() / cellHeight);
            if (column >= 0 && column <= numColumns && row >= 0 && row <= numRows && !cellChecked[column][row]) {
                cellChecked[column][row] = true;
                count++;
                this.porcentage = ((count *100)/(numColumns * numRows));


            }
            invalidate();
        }
    }
}
