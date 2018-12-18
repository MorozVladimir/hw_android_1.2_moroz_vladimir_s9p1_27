package com.example.study_book.hw_android_12_moroz_vladimir_s9p1_27;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener {

    TextView tv;
    float x;
    float y;
    String aDown;
    String aMove;
    String aUp;
    float xn;
    float yn;
    float xk;
    float yk;
    float dx;
    float dy;
    String direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setOnTouchListener(this);
        setContentView(tv);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();



        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                aDown = "Down: " + x + "." + y;
                xn = x;
                yn = y;
                aMove = "";
                aUp = "";
                break;
            case MotionEvent.ACTION_MOVE:
                aMove = "Move: " + x + "." + y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                aMove = "";
                aUp = "Up: " + x + "." + y;
                xk=x;
                yk=y;

                dx = xn - xk;
                dy = yn - yk;
                if(Math.abs(dx)<50 & Math.abs(dy)>50) { direction = "vertical";
                    tv.setBackgroundColor(Color.parseColor("#DDDD16"));
                }else if(Math.abs(dx)>50 & Math.abs(dy)<50) { direction = "horisontal";
                    tv.setBackgroundColor(Color.parseColor("#EB5C5C"));
                }else if(Math.abs(dx)>50 & Math.abs(dy)>50) { direction = "diagonal";
                    tv.setBackgroundColor(Color.parseColor("#4B3B92"));}

                break;
        }
        tv.setText((aDown + "\n" + aMove + "\n" + aUp  + "\n" + direction));



        return true;
    }

}

