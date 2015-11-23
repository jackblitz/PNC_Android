package com.hopkinsdev.howto.com.hopkinsdev.howto.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.Objects.Screen;
import com.hopkinsdev.howto.R;
import com.hopkinsdev.howto.util.LoadUtils;

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
    private TextView mScreenNumber;
    private int mPosition;

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
        mPosition = getArguments().getInt(ARG_POSITION);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.screen_fragment, container,
                false);
        
        mTitle = (TextView)mView.findViewById(R.id.screenTitle);
        mInstructions = (TextView)mView.findViewById(R.id.screenInstuctions);
        mImage = (ImageView)mView.findViewById(R.id.screenImage);
        mScreenNumber = (TextView)mView.findViewById(R.id.screenNumber);
        initScreen();

        return mView;
    }
    
    public void initScreen(){
        if(mCurrentScreen != null){


            if(mCurrentScreen.Title != null && !mCurrentScreen.Title.isEmpty())
                mTitle.setText(mCurrentScreen.Title);
            else
                mTitle.setVisibility(View.GONE);

            mInstructions.setText(Html.fromHtml(mCurrentScreen.Description));
            mScreenNumber.setText(getString(R.string.step) + " " +  Integer.toString(mPosition + 1) + " :");

            if(mCurrentScreen.Image != null && !mCurrentScreen.Image.isEmpty()) {
                mImage.setImageResource(LoadUtils.loadBitmap(getContext(), mCurrentScreen.Image));
            }else
            {
                mImage.setVisibility(View.GONE);
            }
        }
    }
}
