package com.hopkinsdev.howto.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.Objects.Screen;
import com.hopkinsdev.howto.com.hopkinsdev.howto.screens.ScreenFragment;

import java.util.List;

/**
 * Created by Luke on 28/09/2015.
 */
public class ScreenAdapter extends SmartFragmentStatePagerAdapter {

    private final List<Screen> mList;

    public ScreenAdapter(FragmentManager fm, List<Screen> screens) {
        super(fm);
        mList = screens;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {

        return ScreenFragment.newInstance(position, mList.get(position));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    public String getText(int position) {
        // TODO Auto-generated method stub
        //return getFragmentNames(position);

        return "";
    }

}