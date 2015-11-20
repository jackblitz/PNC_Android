package com.hopkinsdev.howto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.hopkinsdev.howto.Objects.Reciepe;
import com.hopkinsdev.howto.adapters.ScreenAdapter;
import com.hopkinsdev.howto.views.CirclePageIndicator;
import com.hopkinsdev.howto.views.CustomViewPager;
import com.hopkinsdev.howto.views.ZoomOutPageTransformer;

/**
 * Created by Luke on 28/09/2015.
 */
public class InstructionsActivity extends ActionBarActivity {


    private ViewPager mViewPager;
    private ScreenAdapter mScreenAdapter;
    private Reciepe mCurrent;
    private Toolbar mToolbar;
    private int viewed = 0;
    private InterstitialAd mInterstitialAd;
    private int mPreviousPage = 0;
    private Button mNextBtn;
    private Button mPreviousBtn;
    private Button mFinishedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.instructions_ad));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();

            }
        });

        requestNewInterstitial();

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCurrent = getIntent().getParcelableExtra("Current");

        mNextBtn = (Button)findViewById(R.id.nextButton);
        mPreviousBtn = (Button)findViewById(R.id.previousButton);
        mPreviousBtn.setEnabled(false);

        mFinishedBtn = (Button)findViewById(R.id.finishButton);
        mFinishedBtn.setVisibility(View.GONE);
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mScreenAdapter = new ScreenAdapter(getSupportFragmentManager(), mCurrent.Screens);
        mViewPager.setAdapter(mScreenAdapter);

        CirclePageIndicator mIndicator = (CirclePageIndicator)findViewById(R.id.viewPageInd);
        mIndicator.setCentered(true);
        mIndicator.setViewPager(mViewPager);
        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(mPreviousPage < position){
                    viewed++;
                }
                mPreviousPage = position;

                if(viewed == 3){
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                }

                if(position == mScreenAdapter.getCount() - 1){
                    mFinishedBtn.setVisibility(View.VISIBLE);
                }else {
                    mFinishedBtn.setVisibility(View.GONE);
                }

                if(mViewPager.getCurrentItem() == 0){
                    mPreviousBtn.setEnabled(false);
                }else
                {
                    mPreviousBtn.setEnabled(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void previousClick(View v){
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
    }

    public void nextClick(View v){
        if(mViewPager.getCurrentItem() == mScreenAdapter.getCount() - 1) {
            finish();
        }
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
    }

    public void finishClick(View v){
        finish();
    }

    private void requestNewInterstitial() {
        viewed = 0;

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("10bf660d5a339224")
                .build();

        mInterstitialAd.loadAd(adRequest);
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
