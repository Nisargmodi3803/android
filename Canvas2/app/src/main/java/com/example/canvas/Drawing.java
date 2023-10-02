package com.example.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.view.View;

public class Drawing extends View
{
    private Paint redBrush,blueBrush,yellowBrush,blackBrush;
    LinearGradient linearGradient;
    RadialGradient radialGradient;

    Bitmap bitmap;
    public Drawing(Context context)
    {
        super(context);
        init();
    }

    public void init()
    {
        redBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        redBrush.setColor(Color.parseColor("red"));

        blueBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        blueBrush.setColor(Color.BLUE);
        blueBrush.setStrokeWidth(50f);
        blueBrush.setStyle(Paint.Style.STROKE);

        yellowBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        yellowBrush.setColor(Color.parseColor("yellow"));

        blackBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        blackBrush.setColor(Color.BLACK);
        blackBrush.setStrokeWidth(20f);
        blackBrush.setStyle(Paint.Style.STROKE);

        linearGradient = new LinearGradient(0,0,20,20,Color.RED,Color.BLUE, Shader.TileMode.MIRROR);
        yellowBrush.setShader(linearGradient);
        blueBrush.setShader(linearGradient);

        radialGradient = new RadialGradient(0,0,30,Color.RED,Color.BLUE,Shader.TileMode.REPEAT);
        redBrush.setShader(radialGradient);
        blackBrush.setShader(radialGradient);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.apex);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
//        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,300f,redBrush);
//        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,300f,blueBrush);

//        canvas.drawRect(200f,400f,600f,200f,yellowBrush);
//        canvas.drawRect(200f,400f,600f,200f,blackBrush);

        canvas.drawBitmap(bitmap,20,70,null);
        canvas.save();
        super.onDraw(canvas);
    }
}
