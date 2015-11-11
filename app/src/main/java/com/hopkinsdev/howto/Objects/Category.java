package com.hopkinsdev.howto.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Luke on 24/09/2015.
 */
public class Category {

    @SerializedName("Id")
    @Expose
    public String Id;

    @SerializedName("Title")
    @Expose
    public String Title;

    @SerializedName("Description")
    @Expose
    public String Description;

    @SerializedName("Image")
    @Expose
    public String Image;

    @SerializedName("Time")
    @Expose
    public String Time;
}
