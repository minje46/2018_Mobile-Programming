package com.example.kwak.android_study1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by KWAK on 2018-05-08.
 */
/*
public class CutomViewDrawables extends View {

    private ShapeDrawable upperDrawable;
    private ShapeDrawable lowerDrawable;

    public CustomViewDrawables(Context context){
        super(context);

        WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point sizePoint = new Point();
        display.getSize(sizePoint);

        int width = sizePoint.x;
        int height = sizePoint.y;

        Resources curRes = getResources();
        int blackColor = curRes.getColor(R.color.colorAccent);
        int grayColor = curRes.getColor(R.color.colorPrimary);
        int darkGrayColor = curRes.getColor(R.color.colorPrimaryDark);

        upperDrawable = new ShapeDrawable();
        RectShape rectangle = new RectShape();
        rectangle.resize(width, height*2/3);
        upperDrawable.setShape(rectangle);
        upperDrawable.setBounds(0,0,width,height*2/3);

        LinearGradient gradient = new LinearGradient(0,0,0,height*2/3,grayColor,blackColor, Shader.TileMode.CLAMP);
        Paint paint = upperDrawable.getPaint();
        paint.setShader(gradient);
        lowerDrawable = new ShapeDrawable();

        RectShape rectangle2 = new RectShape();
        rectangle2.resize(width, height*1/3);

        lowerDrawable.setShape(rectangle2);
        lowerDrawable.setBounds(0,height*2/3, width, height);

        LinearGradient gradient2 = new LinearGradient(0,0,0,height*1/3, blackColor, darkGrayColor, Shader.TileMode.CLAMP);

        Paint paint2 = lowerDrawable.getPaint();
        paint2.setShader(gradient2);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        upperDrawable.draw(canvas);
        lowerDrawable.draw(canvas);
    }
}
*/