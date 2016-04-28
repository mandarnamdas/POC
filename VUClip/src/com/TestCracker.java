package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCracker {

    static List<String> list = new ArrayList<>();

    static void test(Collection c) {
        c.add("New String");
    }

    class A {

        public A() {
            printStr();
        }

        private void printStr() {
            System.out.println("A");
        }
    }

    class B extends A {

        public B() {
            printStr();
        }

        private void printStr() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        test(list);
        System.out.println("Size : " + list.size());
        new TestCracker().new B().printStr();
    }
}
