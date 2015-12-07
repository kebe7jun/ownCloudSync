package com.kebe7jun.data.tools;

import android.util.Log;

import com.kebe7jun.data.code.ConstantCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kebe on 15-12-5.
 */
public class GetFile {

    /**
     * Cache file to disk which gotten from internet.
     * @param url
     * @param data
     */
    public static void cacheFileFromInternet(String url, byte[] data){
        if (url == null || data == null){
            Log.e("cacheFileFromInternet error", "Gotten url or data is null");
            return;
        }
        String fileName = Tools.md5(url);
        File file = new File(ConstantCode.CACHE_PHOTO_PATH+fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data, 0, data.length);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all cached photos name.
     * @return A list of string which include all of the photos' name cached.
     */
    public static List<String> getAllCachedFilesName(){
        return getAllFilesNameFromPath(ConstantCode.CACHE_PHOTO_PATH);
    }

    /**
     * Get all photos' name in local disk.
     * @return
     */
    public static List<String> getAllLocalPhotosName(){
        List<String> localPhotosList = new ArrayList<>();

        return localPhotosList;
    }

    /**
     * Get all files from a dir.
     * If the dir not exists, create a new dir.
     * @return A list of string which include all of the files' name in the path gotten.
     */
    private static List<String> getAllFilesNameFromPath(String path){
        List<String> fileList = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()){        //Dir not exists.
            file.mkdir();       //Create file
            return fileList;
        }
        File[] files = file.listFiles();
        for(File file1 : files){
            fileList.add(file1.getName());       //Add the filename to hashset.
        }
        return fileList;
    }
}
