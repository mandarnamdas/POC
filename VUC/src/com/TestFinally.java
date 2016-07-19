package com;

public class TestFinally {

    public static void main(String[] args) {
        System.out.println(checkFinally());
    }

    public static boolean checkFinally() {

        try {
            return false;
        } finally {
            return true;
        }

    }
}
