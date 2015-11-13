package com.hopkinsdev.howto.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hopkinsdev.howto.Objects.Ingredient;
import com.hopkinsdev.howto.R;

import java.util.List;

/**
 * Created by luke_hopkins on 13/11/15.
 */
public class IngredientsAdapter extends RecyclerView.Adapter {

    private final List<Ingredient> mList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Ingredients;

        public ViewHolder(View v) {
            super(v);
            Ingredients = (TextView) v.findViewById(R.id.ingredient);

        }
    }

    public IngredientsAdapter(List<Ingredient> list){
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Ingredient ing = mList.get(position);
        ((ViewHolder)holder).Ingredients.setText(ing.Value);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
