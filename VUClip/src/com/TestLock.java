package com;

public class TestLock {

    public static void main(String[] args) {

        class A implements Runnable {

            @Override
            public void run() {
                synchronized (String.class) {
                    System.out.println("A is holding String");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("A waiting for Integer..");

                    synchronized (Integer.class) {
                        System.out.println("A got Integer");
                    }

                }

            }

        }

        class B implements Runnable {

            @Override
            public void run() {
                synchronized (String.class) {
                    System.out.println("B is holding Integer");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("B waiting for String..");

                    synchronized (Integer.class) {
                        System.out.println("B got String");
                    }

                }

            }

        }

        Thread t = new Thread(new A());
        Thread t1 = new Thread(new B());
        t.start();
        t1.start();
    }

}
