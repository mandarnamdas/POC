package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    public Employee str = new Employee(4);

    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        A a = new TestThread().new A();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(new TestThread().new B());
        t1.start();
        Thread.sleep(1000);
        t2.start();

    }

    class A implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("Acquired Lock on str and waiting...");
                Thread.sleep(8000);

                System.out.println("Done with waiting..." + str.getId());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    class B implements Runnable {

        @Override
        public void run() {
            str.setId(6);
            System.out.println("Value of Str :" + str.getId());
        }

    }

}
