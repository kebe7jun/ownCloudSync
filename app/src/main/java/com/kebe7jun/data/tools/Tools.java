package com.kebe7jun.data.tools;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.kebe7jun.data.code.ConstantCode;
import com.kebe7jun.data.config.AppSetting;

/**
 * Created by kebe on 15-12-5.
 */
public class Tools {


    /**
     * Calc the md5 value of a string
     * @param toCalcStr
     * @return The md5 value of the string.
     */
    public static String md5(String toCalcStr) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(toCalcStr.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }

    /**
     * Compression the image
     * @param bitmap
     * @return
     */
    public static Bitmap resizeImage(Bitmap bitmap) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
//        float scaleWidth = ((float) AppSetting.getDeviceScreenWidth()/ ConstantCode.COLS_EACH_LINE) / width;
//        float scaleHeight = ((float) AppSetting.getDeviceScreenHeight()/ ConstantCode.COLS_EACH_LINE) / height;
        float scaleWidth = ((float) 200) / width;
        float scaleHeight = ((float) 200) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return resizedBitmap;
    }
}
