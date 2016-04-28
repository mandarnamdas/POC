package com;

public abstract class TestAbstract {

    static {
        System.out.println("Inside static block");
    }

    private TestAbstract() {
    }

    public static void main(String[] args) {
        System.out.println("Main");

    }
}
