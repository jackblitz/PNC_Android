package com.hopkinsdev.howto.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luke on 24/09/2015.
 */
public class Reciepe {

    @SerializedName("Title")
    @Expose
    String Title;

    @SerializedName("Screens")
    @Expose
    List<Screen> Screens;
}
