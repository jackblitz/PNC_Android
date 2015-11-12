package com.hopkinsdev.howto.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.hopkinsdev.howto.R;

/**
 * Created by luke_hopkins on 12/11/15.
 */
public class CutView extends LinearLayout {


    private Paint mPaintLine;
    private Paint mPaint;

    private Path mPath;
    private int Height = 0;
    private int Width = 0;
    public CutView(Context context) {
        super(context);

        init();
    }

    public CutView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public CutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public CutView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init(){
        setWillNotDraw(false);

        mPaint = new Paint();
        mPaint.setColor(Color.LTGRAY);//getContext().getResources().getColor(R.color.primary));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);

        mPaintLine = new Paint();
        mPaintLine.setColor(Color.BLACK);//getContext().getResources().getColor(R.color.primary));
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        Height = getHeight() / 2;
        Width = getHeight() / 4;

        mPath = new Path();
        mPath.moveTo(0, getHeight() / 2);
        mPath.lineTo(getWidth(), Width);
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.lineTo(0, getHeight() / 2);
        mPath.close();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawPath(mPath, mPaint);


        int alpha = 255;
        int take = alpha / 5;
        for(int i = 0; i < 5 ; i++) {
            alpha -= take;
            mPaintLine.setAlpha(alpha);
            canvas.drawLine(0, Height + i, getWidth(), Width + i, mPaintLine);

        }
    }
}
