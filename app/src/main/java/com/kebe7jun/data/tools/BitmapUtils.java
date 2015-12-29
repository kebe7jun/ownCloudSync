package com.kebe7jun.data.tools;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author kebe
 *
 */
public class BitmapUtils
{
    /**
     * @param res
     * @param resId
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources res,
                                                         int resId, int reqWidth, int reqHeight)
    {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, opts);
        int inSampleSize = cacluateInSampleSize(opts, reqWidth, reqHeight);
        opts.inSampleSize = inSampleSize;
        opts.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(res, resId, opts);
        return bitmap;
    }

    /**
     * @param data
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromByteArray(byte[] data,
                                                          int reqWidth, int reqHeight)
    {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(data, 0, data.length, opts);
        int inSampleSize = cacluateInSampleSize(opts, reqWidth, reqHeight);
        opts.inJustDecodeBounds = false;
        opts.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,
                opts);
        return bitmap;
    }

    /**
     * Calc in sample size.
     * @param opts
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    private static int cacluateInSampleSize(BitmapFactory.Options opts,
                                            int reqWidth, int reqHeight)
    {
        if (opts == null)
            return 1;

        int inSampleSize = 1;
        int realWidth = opts.outWidth;
        int realHeight = opts.outHeight;

        if (realHeight > reqHeight || realWidth > reqWidth)
        {
            int heightRatio = realHeight / reqHeight;
            int widthRatio = realWidth / reqWidth;

            inSampleSize = (heightRatio > widthRatio) ? widthRatio
                    : heightRatio;
        }
        return inSampleSize;
    }
}