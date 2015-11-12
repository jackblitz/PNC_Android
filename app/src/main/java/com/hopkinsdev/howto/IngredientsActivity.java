package com.hopkinsdev.howto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.hopkinsdev.howto.adapters.ScreenAdapter;

/**
 * Created by Luke on 28/09/2015.
 */
public class IngredientsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

    }
}
