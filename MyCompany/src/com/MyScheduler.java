package com;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduler {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Thread t = new Thread(new MyScheduler().new MyThread());
        scheduler.scheduleWithFixedDelay(t, 5, 2, TimeUnit.SECONDS);
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Running Thread...");

        }

    }
}
