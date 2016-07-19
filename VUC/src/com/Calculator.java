package com;

public class Calculator {

    int x = 10, y = 10, z;

    public void addtion() {
        z = x + y;
        System.out.println("Result is" + z);
    }

    public void substraction() {
        z = x - y;
        System.out.println("Result is" + z);
    }

    public static void main(String[] args) {
        Calculator1 c1 = new Calculator().new Calculator1();
        c1.addtion();
        c1.substraction();
        c1.Multiplication();
    }

    public class Calculator1 extends Calculator {

        public void Multiplication() {
            z = x * y;
            System.out.println("Result is" + z);
        }
    }

}
