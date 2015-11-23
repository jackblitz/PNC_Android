package com.hopkinsdev.howto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hopkinsdev.howto.Objects.Ingredient;
import com.hopkinsdev.howto.Objects.Reciepe;
import com.hopkinsdev.howto.adapters.IngredientsAdapter;
import com.hopkinsdev.howto.adapters.ScreenAdapter;
import com.hopkinsdev.howto.util.LoadUtils;
import com.hopkinsdev.howto.views.CutView;

import org.w3c.dom.Text;

import java.nio.InvalidMarkException;

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
    private AppBarLayout mAppBarLayout;
    private LinearLayout mLayoutControl;
    private CardView mCardView;
    private TextView mTitle;
    private TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCurrent = getIntent().getParcelableExtra("Current");

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("");

        mCardView = (CardView)findViewById(R.id.card_view);

        mCookTime = (TextView)findViewById(R.id.catTime);
        mCookTime.setText(Html.fromHtml(mCurrent.Time));

        mTitle = (TextView)findViewById(R.id.catTitle);
        mTitle.setText(Html.fromHtml(mCurrent.Title));

        mDescription = (TextView)findViewById(R.id.catDescription);
        mDescription.setText(Html.fromHtml(""));

        ImageView image = (ImageView)findViewById(R.id.catImageView);
        image.setImageResource(LoadUtils.loadBitmap(this, mCurrent.Image));

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

        for(Ingredient i : mCurrent.Ingredients){
            LayoutInflater inflator = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflator.inflate(R.layout.ingredients_item, null);

            TextView amount = (TextView)view.findViewById(R.id.amount);
            TextView value = (TextView)view.findViewById(R.id.ingredient);

            amount.setText(Integer.toString(i.Amount) + i.Unit);
            value.setText(i.Value);

            layout.addView(view);
        }
    }

    public void letsBegin(View v){

        finish();
        Intent i = new Intent(IngredientsActivity.this, InstructionsActivity.class);
        i.putExtra("Current", mCurrent);
        startActivity(i);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
