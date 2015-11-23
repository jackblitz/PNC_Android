package com.hopkinsdev.howto.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 24/09/2015.
 */
public class Reciepe implements Parcelable {

    public Reciepe(Parcel parcel){
        Title = parcel.readString();
        Time = parcel.readString();
        Image = parcel.readString();
        CookFors = parcel.readString();
        Cals = parcel.readString();

        Screens = new ArrayList<>();
        Ingredients = new ArrayList<>();
        parcel.readTypedList(Screens, Screen.CREATOR);
        parcel.readTypedList(Ingredients, Ingredient.CREATOR);
    }

    @SerializedName("Title")
    @Expose
    public String Title;

    @SerializedName("Time")
    @Expose
    public String Time;

    @SerializedName("Image")
    @Expose
    public String Image;

    @SerializedName("CooksFor")
    @Expose
    public String CookFors;

    @SerializedName("Cals")
    @Expose
    public String Cals;

    @SerializedName("Screens")
    @Expose
    public List<Screen> Screens;

    @SerializedName("Ingredients")
    @Expose
    public List<Ingredient> Ingredients;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(Title);
        dest.writeString(Time);
        dest.writeString(Image);
        dest.writeString(CookFors);
        dest.writeString(Cals);
        dest.writeTypedList(Screens);
        dest.writeTypedList(Ingredients);
    }

    public static final Creator<Reciepe> CREATOR = new Creator<Reciepe>() {
        @Override
        public Reciepe createFromParcel(Parcel source) {
            return new Reciepe(source);
        }

        @Override
        public Reciepe[] newArray(int size) {
            return new Reciepe[size];
        }
    };
}
