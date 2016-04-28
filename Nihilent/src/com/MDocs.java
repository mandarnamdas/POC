package com;

public class MDocs {

    public static void main(String[] args) {

        int count = 0;
        int n = 8;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                count = count + i;
                int sub = 0;
                for (int j = 1; j <= i; j++) {
                    System.out.print(count - sub);
                    if (j < i) {
                        System.out.print("*");
                    }
                    sub++;
                }
            } else {
                for (int j = 1; j <= i; j++) {
                    count++;
                    System.out.print(count);
                    if (j < i) {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }
}
