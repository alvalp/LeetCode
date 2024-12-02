package org.alvin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucket {

    // 最后更新时间
    private final AtomicLong lastTimestamp = new AtomicLong(0);

    // 每一秒钟的速率
    private int rate;

    private static Object lock = new Object();

    /**
     * 超时时间
     */
    private int timeout;


    public LeakyBucket(int rate, int timeout) {
        this.rate = rate;
        this.timeout = timeout;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();
        int cost = 1000 / rate;

        long expectTime = lastTimestamp.get() + cost;
        if (expectTime < now) {
            synchronized (lock) {
                expectTime = lastTimestamp.get() + cost;
                if (expectTime < now) {
                    lastTimestamp.set(now);
                    System.out.println("success" + expectTime + " <" + now);
                    return true;
                } else {
                    return waitelimit(now, cost);
                }
            }
        } else {
            return waitelimit(now, cost);
        }
    }

    private boolean waitelimit(long now, long cost) {
        long fireTime = lastTimestamp.addAndGet(cost);
        long waiteTime = fireTime - now;
        if (waiteTime > timeout) {
            // 超时了
            System.out.println("full block");
            return false;
        }

        try {
            System.out.println("sleep ->" + fireTime);
            Thread.sleep(waiteTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static void main(String[] args) {
        LeakyBucket leakyBucket = new LeakyBucket(10, 300);
        try {
            Thread.sleep(160);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    leakyBucket.limit();
                }
            });
        }
        executorService.shutdown();
    }

}
