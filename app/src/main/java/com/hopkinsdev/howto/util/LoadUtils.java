package com.hopkinsdev.howto.util;

import android.content.Context;
import android.content.res.Resources;

import java.io.InputStream;

/**
 * Created by Luke on 28/09/2015.
 */
public class LoadUtils {

    public static String loadResourceByName(Context context, String name){
        try {
            Resources res = context.getResources();
            InputStream in_s = context.getResources().openRawResource(
                    context.getResources().getIdentifier("raw/" + name,
                            "json", context.getPackageName()));

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            return new String(b);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;
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
}
