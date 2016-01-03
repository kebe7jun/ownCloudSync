package com.kebe7jun.data.tools;

import android.util.Log;

import com.kebe7jun.data.code.ConstantCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
     * Camera photo path.
     */
    private static final String CAMERA_PHOTOS_PATH = "/sdcard/DCIM/Camera/";

    /**
     * Cache photo path.
     */
    public static final String CACHE_PHOTO_PATH = "/sdcard/ownCloudSync/";

    /**
     * To get the path of the device save photo.
     * @return
     */
    private static String getCameraPhotosPath(){
        return CAMERA_PHOTOS_PATH;
    }

    /**
     * Get cached photo path.
     * @return
     */
    private static String getCachePhotoPath(){
        return CACHE_PHOTO_PATH;
    }

    /**
     * Cache file to disk which gotten from internet.
     * @param url
     * @param data
     */
    public static void cacheFileFromInternet(String url, byte[] data){
        if (url == null || data == null){
            Log.e("cacheFile error", "Gotten url or data is null");
            return;
        }
        String fileName = Tools.md5(url);
        File file = new File(getCachePhotoPath()+fileName);
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
        return getAllFilesNameFromPath(getCachePhotoPath());
    }

    /**
     * Get all photos' name in local disk.
     * @return
     */
    public static List<String> getAllLocalPhotosName(){
        List<String> fileNameList = getAllFilesNameFromPath(getCameraPhotosPath());
        List<String> toBeReturnList = new ArrayList<>();
        for (String fileName : fileNameList){   //Check the file is a photo
            String lastFix = fileName.substring(fileName.length()-4, fileName.length()).toLowerCase();
            if (lastFix.compareTo(".jpg") == 0){
                toBeReturnList.add(fileName);
            }
            else {
                Log.w("Local FIle", fileName+" is not a pic.");
            }
        }
        return toBeReturnList;
    }

    /**
     * Get a local photo.
     * @param photoName
     * @return
     */
    public static byte[] getLocalPhotoByName(String photoName){
        return readPhoto(getCameraPhotosPath()+photoName);
    }

    public static byte[] getCachedPhotoByName(String photoName){
        return readPhoto(getCachePhotoPath()+photoName);
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
            file.mkdir();       //Create dir.
            return fileList;
        }
        try {
            File[] files = file.listFiles();
            for(File file1 : files){
                fileList.add(file1.getName());       //Add the filename to hashset.
            }
        }
        catch (Exception e){
            //If dir not exists, or this app don't have permission to access the file.
        }
        return fileList;        //Return fileList anyway.
    }

    /**
     * Read a photo to binary from given path.
     * @param path
     * @return
     */
    private static byte[] readPhoto(String path){
        byte[] photo = null;
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            photo = new byte[(int) file.length()];
            fileInputStream.read(photo, 0, photo.length);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return photo;
    }
}
