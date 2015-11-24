package com.hopkinsdev.howto.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.hopkinsdev.howto.Objects.Screen;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Locale;

/**
 * Created by Luke on 28/09/2015.
 */
public class LoadUtils {

    public static String loadResourceByName(Context context, String name){
        try {
            String langFolder = "raw";

            //langFolder += getLanguageFolder();

            langFolder += "/";

            String file = langFolder + name;
            Resources res = context.getResources();
            InputStream in_s = context.getResources().openRawResource(
                    context.getResources().getIdentifier(file,
                            "json", context.getPackageName()));

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            return new String(b);
        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }

    private static String getLanguageFolder() {

        String locale = Locale.getDefault().getLanguage();
        String value = "-";
        if(!locale.equals("en"))
        {
            return value + locale;
        }else
             return "";
    }

    public static String loadResourceById(Context context, int id){
        try {
            Resources res = context.getResources();
            InputStream in_s = context.getResources().openRawResource(id);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            return new String(b);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;
    }

    public static int loadBitmap(Context context, String name){
            return context.getResources().getIdentifier(name, "drawable",  context.getPackageName());

    }
}
