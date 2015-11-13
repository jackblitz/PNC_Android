package com.hopkinsdev.howto.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Luke on 24/09/2015.
 */
public class Screen implements Parcelable {

    @SerializedName("Id")
    @Expose
    public int Id = 0;

    @SerializedName("ScreenType")
    @Expose
    public int ScreenType = 0;

    @SerializedName("Title")
    @Expose
    public String Title;

    @SerializedName("Description")
    @Expose
    public String Description;

    @SerializedName("Remaining")
    @Expose
    public String Remaining;

    @SerializedName("Image")
    @Expose
    public String Image;

    @Override
    public int describeContents() {
        return 0;
    }

    public Screen(Parcel parcel){
        Id = parcel.readInt();
        ScreenType = parcel.readInt();
        Title = parcel.readString();
        Description = parcel.readString();
        Remaining = parcel.readString();
        Image = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(Id);
        dest.writeInt(ScreenType);
        dest.writeString(Title);
        dest.writeString(Description);
        dest.writeString(Remaining);
        dest.writeString(Image);
    }

    public static final Creator<Screen> CREATOR = new Creator<Screen>() {
        @Override
        public Screen createFromParcel(Parcel source) {
            return new Screen(source);
        }

        @Override
        public Screen[] newArray(int size) {
            return new Screen[size];
        }
    };

}
