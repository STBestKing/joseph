package com.example.joseph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PeopleView extends View {

    int init = R.drawable.init;
    int show = R.drawable.show;
    int shut = R.drawable.shut;
    float width1, height1;
    Paint paint;
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), init);
    Matrix matrix;

    public PeopleView(Context context) {
        super(context);
    }

    public PeopleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PeopleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PeopleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width1 = (float)(bitmap.getWidth()*1.5/2);
        height1 = (float)(bitmap.getHeight()*1.5/2);
        matrix = new Matrix();
        matrix.setScale(0.2f,0.2f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,matrix,paint);
        invalidate();
    }

    protected void setPaintinit() {
        bitmap = BitmapFactory.decodeResource(getResources(),init);
    }

    protected void setPaintshow() {
        bitmap = BitmapFactory.decodeResource(getResources(),show);
    }

    protected void setPaintshut() {
        bitmap = BitmapFactory.decodeResource(getResources(),shut);
    }
}
