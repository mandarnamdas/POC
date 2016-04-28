package com;

import java.util.concurrent.TimeUnit;

public class TestDeadLockDetector {

    public static void main(String[] args) {

        DeadLockDetector deadLockDetector = new DeadLockDetector();
        deadLockDetector.start();
        thread1.start();
        thread2.start();
    }

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    static Thread thread1 = new Thread(new Runnable() {

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread1 acquired lock1");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException ignore) {
                }
                synchronized (lock2) {
                    System.out.println("Thread1 acquired lock2");
                }
            }
        }

    });

    static Thread thread2 = new Thread(new Runnable() {

        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread2 acquired lock2");
                synchronized (lock1) {
                    System.out.println("Thread2 acquired lock1");
                }
            }
        }
    });

}
