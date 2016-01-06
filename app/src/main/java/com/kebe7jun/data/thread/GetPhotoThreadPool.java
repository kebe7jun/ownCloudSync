package com.kebe7jun.data.thread;

import com.kebe7jun.data.interfaces.GetImageCallable;
import com.kebe7jun.data.interfaces.WorkDoneCallback;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kebe on 15-12-7.
 */
public class GetPhotoThreadPool {

    /**
     * The thread counts of the thread pool.
     */
    private static final int MAX_THREAD_COUNTS = 5;

    /**
     * Running work count.
     */
    private static int runningWorkCount = 0;

    private static ExecutorService executor;

    /**
     * This table store the work to do.
     */
    private static Hashtable<String, GetImageCallable> photoUrlGettingTable = new Hashtable();

    static {
        executor = Executors.newFixedThreadPool(MAX_THREAD_COUNTS);
    }

    /**
     * Add get image work to the thread pool.
     * @param url
     * @param getImageCallable
     */
    public static void getImage(String url, GetImageCallable getImageCallable){
        photoUrlGettingTable.put(url, getImageCallable);
        doNewWork();
    }

    /**
     * After a work done.
     * @param imageGotten
     */
    public static void onWorkDone(String imageGotten){
        runningWorkCount--;
        doNewWork();
    }

    /**
     * Do a new work.
     */
    private static void doNewWork(){
        if (runningWorkCount < MAX_THREAD_COUNTS && photoUrlGettingTable.size()>0) {
            String url = photoUrlGettingTable.keys().nextElement();
            Runnable runnable = new GetPhotoThread(url, photoUrlGettingTable.get(url), new WorkDoneCallback(){

                @Override
                public void workDone(Object obj) {
                    onWorkDone((String) obj);
                }
            });
            executor.execute(runnable);
            runningWorkCount++;
            //After call a new thread, delete this work from table.
            photoUrlGettingTable.remove(url);
        }
    }
}
