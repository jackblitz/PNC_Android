package com.hopkinsdev.howto.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by luke_hopkins on 13/11/15.
 */
public class Ingredient implements Parcelable{

    @SerializedName("Amount")
    @Expose
    public int Amount;

    @SerializedName("Value")
    @Expose
    public String Value;

    @SerializedName("Unit")
    @Expose
    public String Unit;

    public Ingredient(Parcel parcel){
        Amount = parcel.readInt();
        Value = parcel.readString();
        Unit = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(Amount);
        dest.writeString(Value);
        dest.writeString(Unit);
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
