package com.hopkinsdev.howto.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.com.hopkinsdev.howto.screens.ScreenFragment;

/**
 * Created by Luke on 28/09/2015.
 */
public class ScreenAdapter extends SmartFragmentStatePagerAdapter {

    public ScreenAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {

        return ScreenFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Application.getInstance().getScreenCount();
    }

    public String getText(int position) {
        // TODO Auto-generated method stub
        //return getFragmentNames(position);

        return "";
    }

}