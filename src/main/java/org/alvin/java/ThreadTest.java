package org.alvin.java;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {


    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ExecutorService executorService = new ThreadPoolExecutor(4, 8, 100, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> System.out.println("hello"));
        }

        executorService.shutdown();
    }
}
