package com;

import java.util.Arrays;

public class MyCustomeArrayList<T> {

    Object[] element;

    int size;

    public void add(T t) {

        if (element == null) {
            element = new Object[10];
        } else if (size == element.length - 1) {
            int newSize = (element.length * 3) / 2 + 1;
            element = Arrays.copyOf(element, newSize);
        }
        element[size] = t;
        size++;

    }

    public T get(int position) {
        return (T) element[position];
    }

    public static void main(String args[]) {

        MyCustomeArrayList<Integer> list = new MyCustomeArrayList<Integer>();
        list.add(10);
        list.add(20);

        System.out.println(list.get(1));
    }
}
