package com.hopkinsdev.howto.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Luke on 24/09/2015.
 */
public class Screen {

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

}
