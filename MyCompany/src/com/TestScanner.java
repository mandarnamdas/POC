package com;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class TestScanner {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());

    }
}
