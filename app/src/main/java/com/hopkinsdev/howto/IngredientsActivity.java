package com.hopkinsdev.howto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.hopkinsdev.howto.Objects.Reciepe;
import com.hopkinsdev.howto.adapters.IngredientsAdapter;
import com.hopkinsdev.howto.adapters.ScreenAdapter;
import com.hopkinsdev.howto.views.CutView;

/**
 * Created by Luke on 28/09/2015.
 */
public class IngredientsActivity extends ActionBarActivity {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private Reciepe mCurrent;
    private IngredientsAdapter mAdapter;
    private CollapsingToolbarLayout collapsingToolbar;
    private CutView mCutView;
    private TextView mCookTime;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCurrent = getIntent().getParcelableExtra("Current");

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("");

        mRecyclerView = (RecyclerView)findViewById(R.id.ingredients);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new IngredientsAdapter(mCurrent.Ingredients);
        mRecyclerView.setAdapter(mAdapter);
        
        mCutView = (CutView)findViewById(R.id.cutView);
        mCutView.setHeightListener(new CutView.onLevelingHeight() {
            @Override
            public void onHeightChanged(int value) {
                collapsingToolbar.setMinimumHeight(value);
        }});
        
        mCookTime = (TextView)findViewById(R.id.catTime);
        mCookTime.setText(Html.fromHtml(mCurrent.Time));
    }

    public void letsBegin(View v){

        Intent i = new Intent(IngredientsActivity.this, InstructionsActivity.class);
        i.putExtra("Current", mCurrent);
        startActivity(i);

    }
}
