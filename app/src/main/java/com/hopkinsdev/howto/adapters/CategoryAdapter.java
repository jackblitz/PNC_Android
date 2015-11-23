package com.hopkinsdev.howto.adapters;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.Objects.Category;
import com.hopkinsdev.howto.R;
import com.hopkinsdev.howto.util.LoadUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 28/09/2015.
 */
public class CategoryAdapter extends BaseAdapter {

    public class ViewHolder
    {
        TextView Title;
        TextView Description;
        TextView Time;
        ImageView Image;
    }

    private List<Category> mList;

    private boolean isScrolling;
    private int mLastPosition;
    private Context mContext;

    public CategoryAdapter(Context context){
        mContext = context;
        mList = Application.getInstance().getCategories();

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder viewHolder = null;
        View view =  convertView;

        Category cat = mList.get(position);

        if (view == null) {

            LayoutInflater inflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(R.layout.categoryitem, null);

            viewHolder = new ViewHolder();
            viewHolder.Title = (TextView)view.findViewById(R.id.catTitle);
            viewHolder.Time = (TextView)view.findViewById(R.id.catTime);
            viewHolder.Description = (TextView)view.findViewById(R.id.catDescription);
            viewHolder.Image = (ImageView)view.findViewById(R.id.catImageView);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }


        if(viewHolder != null)
        {
            viewHolder.Title.setText(cat.Title);
            viewHolder.Description.setText(cat.Description);
            viewHolder.Time.setText(Html.fromHtml(cat.Time));


            if(cat.Image != null && !cat.Image.isEmpty()){
                viewHolder.Image.setImageResource(LoadUtils.loadBitmap(mContext, cat.Image));
            }
        }

        return view;
    }

    public void animationViewOnScroll(View v, int position){
        if(isScrolling){
            float initialTranslation = (mLastPosition <= position ? 500f : -500f);

            v.setTranslationY(initialTranslation);
            v.animate()
                    .setInterpolator(new DecelerateInterpolator(1.0f))
                    .translationY(0f)
                    .setDuration(300l)
                    .setListener(null);
        }

        mLastPosition = position;
    }

    public void setIsScrolling(boolean isScroll){
        isScrolling = isScroll;
    }

}
