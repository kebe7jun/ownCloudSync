package com.kebe7jun.data.thread;

import com.kebe7jun.data.interfaces.GetImageCallable;

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
    private static ExecutorService executor;

    static {
        executor = Executors.newFixedThreadPool(MAX_THREAD_COUNTS);
    }

    /**
     * Add get image work to the thread pool.
     * @param url
     * @param getImageCallable
     */
    public static void addWork(String url, GetImageCallable getImageCallable){
        Runnable runnable = new GetPhotoThread(url, getImageCallable);
        executor.execute(runnable);
    }
}
