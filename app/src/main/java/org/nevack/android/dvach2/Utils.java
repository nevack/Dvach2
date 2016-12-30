package org.nevack.android.dvach2;

import android.content.Context;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class Utils {
    private static Picasso instance;

    public static String formatSize(int size) {
        if (size < 1000) return String.valueOf(size) + "kb";
        return new DecimalFormat("#.#").format(size / 1000d) + "mb";
    }

    public static Picasso getPicasso(Context context) {
        if (instance == null) {
            instance = new Picasso.Builder(context.getApplicationContext())
                    .build();
        }
        return instance;
    }
}
