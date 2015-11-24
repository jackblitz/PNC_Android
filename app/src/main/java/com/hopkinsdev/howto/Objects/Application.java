package com.hopkinsdev.howto.Objects;

import com.hopkinsdev.howto.BaseApplication;
import com.hopkinsdev.howto.R;
import com.hopkinsdev.howto.util.JsonEncoder;
import com.hopkinsdev.howto.util.LoadUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 24/09/2015.
 */
public class Application extends BaseApplication{

    List<Category> Categories;
    private Screen mNextScreen;
    private int ScreenCount;

    static Application mInstance;
    private Screen nextScreen;
    private String mAppTitle;
    private Reciepe mCurrentReceipe;


    public static Application getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if(mInstance == null)
            mInstance = this;

        String catFile = LoadUtils.loadResourceByName(this, "categories");

        Categories = new ArrayList<>();

        if(!catFile.isEmpty())
            loadCategories(catFile);
    }

        private void loadCategories(String file) {
            try {
            JSONObject response = new JSONObject(file);
            JSONArray jsonArray;

            mAppTitle = response.getString("Title");

            jsonArray = response.getJSONArray("Categories");

            int length = jsonArray.length();
            for(int i=0;i<length;i++){
                JSONObject jsonItem = jsonArray.getJSONObject(i);
                Categories.add((Category) JsonEncoder.fromJson(jsonItem.toString(), Category.class));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Category> getCategories(){
        return Categories;
    }



    public Reciepe getReceipe(String file) throws Exception {
        try {

            String item = LoadUtils.loadResourceByName(this, file);

            return (Reciepe) JsonEncoder.fromJson(item, Reciepe.class);
        }catch (Exception e) {
            throw e;
        }
    }

    public Screen getScreen(int index) {

        if (mCurrentReceipe != null) {
            try {
                return mCurrentReceipe.Screens.get(index);
            } catch (Exception e) {
                return null;
            }
        }

        return null;
    }
    public int getScreenCount(){
        return mCurrentReceipe.Screens.size();
    }



}
