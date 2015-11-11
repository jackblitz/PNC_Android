package com.hopkinsdev.howto.com.hopkinsdev.howto.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.Objects.Screen;

/**
 * Created by Luke on 28/09/2015.
 */
public class BaseFragment extends Fragment {

    public Screen mCurrentScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  mCurrentScreen = Application.getInstance().getNextScreen();

    }

}

