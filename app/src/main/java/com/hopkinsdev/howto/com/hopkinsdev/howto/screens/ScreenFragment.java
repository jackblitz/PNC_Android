package com.hopkinsdev.howto.com.hopkinsdev.howto.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.Objects.Screen;
import com.hopkinsdev.howto.R;

/**
 * Created by Luke on 28/09/2015.
 */
public class ScreenFragment extends BaseFragment {

    static final String ARG_POSITION = "pos";
    static final String CURRENT_SCREEN = "screen";
    private View mView;
    private TextView mTitle;
    private TextView mInstructions;
    private ImageView mImage;

    public static ScreenFragment newInstance(int page, Screen screen) {
        ScreenFragment fragmentFirst = new ScreenFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, page);
        args.putParcelable(CURRENT_SCREEN, screen);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentScreen = getArguments().getParcelable(CURRENT_SCREEN);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.screen_fragment, container,
                false);
        
        mTitle = (TextView)mView.findViewById(R.id.screenTitle);
        mInstructions = (TextView)mView.findViewById(R.id.screenInstuctions);
        mImage = (ImageView)mView.findViewById(R.id.screenImage);

        initScreen();

        return mView;
    }
    
    public void initScreen(){
        if(mCurrentScreen != null){
            mTitle.setText(mCurrentScreen.Title);
            mInstructions.setText(mCurrentScreen.Description);
           // mImage
        }
    }
}
