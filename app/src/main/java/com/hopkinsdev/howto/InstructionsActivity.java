package com.hopkinsdev.howto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.hopkinsdev.howto.Objects.Reciepe;
import com.hopkinsdev.howto.adapters.ScreenAdapter;
import com.hopkinsdev.howto.views.CustomViewPager;
import com.hopkinsdev.howto.views.ZoomOutPageTransformer;

/**
 * Created by Luke on 28/09/2015.
 */
public class InstructionsActivity extends ActionBarActivity {


    private ViewPager mViewPager;
    private ScreenAdapter mScreenAdapter;
    private Reciepe mCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        mCurrent = getIntent().getParcelableExtra("Current");
        
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mScreenAdapter = new ScreenAdapter(getSupportFragmentManager(), mCurrent.Screens);
        mViewPager.setAdapter(mScreenAdapter);

        CustomViewPager mIndicator = (CustomViewPager)findViewById(R.id.viewPageInd);
        mIndicator.setCentered(false);
        mIndicator.setViewPager(mViewPager);
    }
}
