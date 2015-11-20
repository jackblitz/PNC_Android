package com.hopkinsdev.howto.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
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
    private onLevelingHeight mListener;

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
        mPaint.setColor(getContext().getResources().getColor(R.color.primary));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);

        mPaintLine = new Paint();
        mPaintLine.setColor(Color.DKGRAY);//getContext().getResources().getColor(R.color.primary));
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



        Width = getHeight() / 4;
        Height = getHeight() - Width;

        mPath = new Path();
        mPath.moveTo(0, Height);
        mPath.lineTo(getWidth(), Width);
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.lineTo(0, Height);
        mPath.close();
        if(mListener != null){
            mListener.onHeightChanged(getHeight(), Width);
        }


    }

    public void setHeightListener(onLevelingHeight listener){
        mListener = listener;
    }

    public interface onLevelingHeight{
        public void onHeightChanged(int height, int value);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawPath(mPath, mPaint);


        int alpha = 255;
        int take = alpha / 15;
        for(int i = 0; i < 15 ; i++) {
            alpha -= take;
            mPaintLine.setAlpha(alpha);
            canvas.drawLine(0, Height + i, getWidth(), Width + i, mPaintLine);

        }
    }

 /*   @SuppressWarnings("unused")
    public class CutViewBehavior extends CoordinatorLayout.Behavior<CutViewBehavior> {

        private final static float MIN_AVATAR_PERCENTAGE_SIZE   = 0.3f;
        private final static int EXTRA_FINAL_AVATAR_PADDING     = 80;

        private final static String TAG = "behavior";
        private final Context mContext;
        private float mAvatarMaxSize;

        private float mFinalLeftAvatarPadding;
        private float mStartPosition;
        private int mStartXPosition;
        private float mStartToolbarPosition;

        public CutViewBehavior(Context context, AttributeSet attrs) {
            mContext = context;
            init();

            mFinalLeftAvatarPadding = 2///context.getResources().getDimension(
                   // R.dimen.spacing_normal);
        }

        private void init() {
            bindDimensions();
        }

        private void bindDimensions() {
            mAvatarMaxSize = 2;//mContext.getResources().getDimension(R.dimen.image_width);
        }

        private int mStartYPosition;

        private int mFinalYPosition;
        private int finalHeight;
        private int mStartHeight;
        private int mFinalXPosition;
        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, CutViewBehavior child, View dependency) {
            return dependency instanceof Toolbar;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, CutViewBehavior child, View dependency) {
            shouldInitProperties(child, dependency);

            final int maxScrollDistance = (int) (mStartToolbarPosition - getStatusBarHeight());
            float expandedPercentageFactor = dependency.getY() / maxScrollDistance;

            float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
                    * (1f - expandedPercentageFactor)) + (child.getHeight()/2);

            float distanceXToSubtract = ((mStartXPosition - mFinalXPosition)
                    * (1f - expandedPercentageFactor)) + (child.getWidth()/2);

            float heightToSubtract = ((mStartHeight - finalHeight) * (1f - expandedPercentageFactor));

            child.setY(mStartYPosition - distanceYToSubtract);
            child.setX(mStartXPosition - distanceXToSubtract);

            int proportionalAvatarSize = (int) (mAvatarMaxSize * (expandedPercentageFactor));

            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            lp.width = (int) (mStartHeight - heightToSubtract);
            lp.height = (int) (mStartHeight - heightToSubtract);
            child.setLayoutParams(lp);
            return true;
        }

        private void shouldInitProperties(CutViewBehavior child, View dependency) {
            if (mStartYPosition == 0)
                mStartYPosition = (int) (child.getY() + (child.getHeight() / 2));

            if (mFinalYPosition == 0)
                mFinalYPosition = (dependency.getHeight() /2);

            if (mStartHeight == 0)
                mStartHeight = child.getHeight();

            if (finalHeight == 0)
                finalHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.image_final_width);

            if (mStartXPosition == 0)
                mStartXPosition = (int) (child.getX() + (child.getWidth() / 2));

            if (mFinalXPosition == 0)
                mFinalXPosition = mContext.getResources().getDimensionPixelOffset(R.dimen.abc_action_bar_content_inset_material) + (finalHeight / 2);

            if (mStartToolbarPosition == 0)
                mStartToolbarPosition = dependency.getY() + (dependency.getHeight()/2);
        }

        public int getStatusBarHeight() {
            int result = 0;
            int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");

            if (resourceId > 0) {
                result = mContext.getResources().getDimensionPixelSize(resourceId);
            }
            return result;
        }*/
}
