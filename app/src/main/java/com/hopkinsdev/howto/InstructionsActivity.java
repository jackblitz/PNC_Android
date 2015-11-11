package com.hopkinsdev.howto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.hopkinsdev.howto.adapters.ScreenAdapter;

/**
 * Created by Luke on 28/09/2015.
 */
public class InstructionsActivity extends ActionBarActivity {


    private ViewPager mViewPager;
    private ScreenAdapter mScreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mScreenAdapter = new ScreenAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mScreenAdapter);
    }
}
