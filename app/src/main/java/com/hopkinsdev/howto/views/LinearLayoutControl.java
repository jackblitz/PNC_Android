package com.hopkinsdev.howto.views;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hopkinsdev.howto.IngredientsActivity;
import com.hopkinsdev.howto.Objects.Ingredient;
import com.hopkinsdev.howto.R;


/**
 * Created by luke_hopkins on 16/11/15.
 */
@SuppressWarnings("unused")
public class LinearLayoutControl extends CoordinatorLayout.Behavior<LinearLayout> {

    private final static String TAG = "behavior";
    private final Context mContext;
    private int mTopPadding;
    private View mCircle;
    private float mStartToolbarPosition;
    private ImageView mImageView;
    private Toolbar mToolBar;


    public LinearLayoutControl(Context context) {

      //  super();
        mContext = context;
        init();
    }


    public LinearLayoutControl(Context context, AttributeSet attrs, int defStyleAttr) {
        //super(context, attrs, defStyleAttr);
        mContext = context;
        init();

    }
    public LinearLayoutControl(Context context, AttributeSet attrs) {
        //super();
        mContext = context;
        init();

    }

    private void init() {
        mTopPadding = mContext.getResources().getDimensionPixelOffset(R.dimen.toPadding);
    }
    float mStartYPosition = 0;
    float mFinalYPosition = 0;

    private void shouldInitProperties(LinearLayout child, View dependency) {



        if (mStartToolbarPosition == 0)
            mStartToolbarPosition = dependency.getY() + (dependency.getHeight()/2);
        
        if(mImageView == null)
            mImageView = (ImageView)dependency.findViewById(R.id.catImageView);

        if(mToolBar == null)
            mToolBar = (Toolbar)dependency.findViewById(R.id.toolbar);

        if (mStartYPosition == 0){
            mStartYPosition =  mImageView.getHeight() / 2;
        }


        if (mFinalYPosition == 0)
            mFinalYPosition = mToolBar.getHeight();

    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {

        return true;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final LinearLayout child, View dependency) {

        shouldInitProperties(child, dependency);


       /* float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
                * (1f - expandedPercentageFactor)) + (child.getHeight()/2);*/

        /*float scrollDistance = mStartYPosition - mFinalYPosition;
        float scrollDistanceOfDependency = dependency.getHeight();

        float percentOfScroll =  scrollDistance / dependency.getY() * 100;

        Log.e("y",Float.toString(dependency.getY()));
        Log.e("scroll",Float.toString(percentOfScroll));
        float position = dependency.getY() / scrollDistance * 100;

        //float heightToSubtract = ((mStartHeight - finalHeight) * (1f - expandedPercentageFactor));*/

        //child.setY(mStartYPosition + dependency.getY();
        float scroll = dependency.getY() - (dependency.getHeight()) + mStartYPosition / 2;
        //Log.e("y",Float.toString(dependency.getY() - (dependency.getHeight()) + mStartYPosition / 2));
        //Log.e("scroll",Float.toString(dependency.getHeight() / 2));

        if(scroll * -1 < dependency.getHeight() / 2){
            child.setTranslationY(dependency.getY() - (dependency.getHeight()) + mStartYPosition / 2);
        }else
        {

        }



        return true;
    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}