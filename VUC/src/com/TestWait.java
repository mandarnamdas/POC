package com;

public class TestWait {

    public static void main(String[] args) {

        final String str = "abcd";

        class A implements Runnable {

            @Override
            public void run() {

                System.out.println("A waiting");
                try {
                    synchronized (str) {

                        str.wait();
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("A after waiting");
            }

        }

        class B implements Runnable {

            @Override
            public void run() {
                System.out.println("B waiting");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (str) {

                    System.out.println("B after waiting");
                    str.notify();
                }
            }

        }

        Thread t = new Thread(new A());
        Thread t1 = new Thread(new B());
        t.start();
        t1.start();
    }

}
