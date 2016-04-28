package com;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadLockDetector {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private final ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
    private final Runnable deadlockCheck = new Runnable() {

        @Override
        public void run() {
            System.out.println("Checking Deadlock");
            long[] deadLockThreadIds = mbean.findDeadlockedThreads();
            if (deadLockThreadIds != null) {
                ThreadInfo[] threadInfo = DeadLockDetector.this.mbean.getThreadInfo(deadLockThreadIds);
                System.out.println("getting info");
                for (ThreadInfo threadInfo2 : threadInfo) {
                    System.out.println(threadInfo2.toString().trim());
                }
            }
        }
    };

    public void start() {
        scheduledExecutorService.scheduleWithFixedDelay(deadlockCheck, 2, 2, TimeUnit.SECONDS);
    }
}
