package com;

public class TestFinalize {

    public static void main(String[] args) throws Throwable {
        System.out.println("Inside Main");
        System.runFinalization();
        Runtime.getRuntime().runFinalization();
        sayHello();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Before garbage collection....");
        super.finalize();
    }

    public static void sayHello() {
        System.out.println("Hello Mandar");
    }
}
