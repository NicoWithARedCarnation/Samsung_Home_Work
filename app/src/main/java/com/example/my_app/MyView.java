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
    public MyView(Context context) {
        super(context);
        for (int i = 0; i < N; i++) {
            x[i] = (float) (Math.random() * 500);
            y[i] = (float) (Math.random() * 500);
            vx[i] = (float) (Math.random() * 6 - 3);
            vy[i] = (float) (Math.random() * 6 - 3);
        }
    }
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas){
        // отрисовываем все шарики
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 10, paint);
        }
        for (int i = 0; i < N - 1; i++) { //добавила линии
            canvas.drawLine(x[i], y[i], x[i + 1], y[i + 1], paint);
        }
        paint.setColor(Color.BLUE); //поменла цвет
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
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