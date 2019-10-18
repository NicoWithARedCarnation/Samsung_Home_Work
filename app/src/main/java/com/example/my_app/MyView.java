package com.example.my_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class MyView extends View {


    int N = 50; // количество шариков
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }
    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }
    public MyView(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, -3,3);
    }
    Paint paint = new Paint();
    void add(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }
    @Override
    protected void onDraw(Canvas canvas){
        // отрисовываем все шарики
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 10, paint);

        }
        paint.setColor(Color.BLUE); //поменла цвет
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            add(x, vx);
            add(y, vy);
            if (x[i] < 15 || x[i] > this.getWidth()-10){  // шарики не выходят за поля экрана
                vx[i] = - vx[i];
            }
            if (y[i] < 15 || y[i] > this.getHeight()-10){
                vy[i] = - vy[i];
            }

        }
        //запрашиваем перерисовку
        invalidate();
    }
}
