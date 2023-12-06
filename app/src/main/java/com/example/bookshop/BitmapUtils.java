package com.example.bookshop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtils {

    // Convert byte array to Bitmap
    public static Bitmap getBitmapFromByteArray(byte[] byteArray) {
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }
}

