package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.view.View;

public class Drawing extends View
{
    private Paint brush;
    private Paint redBrush;
    private RadialGradient radialGradient;
    private LinearGradient linearGradient;
    public Drawing(Context context)
    {
        super(context);
        init();
    }

    private void init()
    {
//        brush = new Paint(Paint.ANTI_ALIAS_FLAG);
//        brush.setColor(Color.parseColor("red"));
//        brush.setColor(Color.YELLOW);

        redBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        redBrush.setColor(Color.parseColor("green"));
        redBrush.setStrokeWidth(50f);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,308f,brush);
        canvas.drawLine(0,0,getMeasuredWidth()/2,getMeasuredHeight()/2,redBrush);
        canvas.save();
        super.onDraw(canvas);
    }

}
