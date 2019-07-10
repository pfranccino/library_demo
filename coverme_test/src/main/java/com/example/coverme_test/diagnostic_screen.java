package com.example.coverme_test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class diagnostic_screen {

    Context context ;
    grid_draw gr ;

    public diagnostic_screen(Context context){
        this.context = context;
        this.gr = new grid_draw(context);


    }

    public void draw(Activity activity, int numColumns, int numRows ){
        gr.setNumColumns(numColumns);
        gr.setNumRows(numRows);
        gr.setBackgroundColors(Color.GREEN);
        gr.setColor(Color.RED);
        hideSystemUi(activity);
        activity.setContentView(gr);

    }

    private void hideSystemUi(Activity activity){
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                 View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                 View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                 View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                 View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                 View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public void onTouchItem(MotionEvent event){
        gr.onSelect(event);
    }

    public Double getPorcentage(){
      return   gr.getPorcentage();
    }


}
