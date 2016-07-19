package com;

import java.util.Arrays;

public class TestArrayList {

    {
        System.out.println("Init Block");
    }
    static {
        System.out.println("Staic Block");
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new TestArrayList().new CustomArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        Character[] password = {
            'p', 'a', 's', 's', 'w', 'r', 'd'
        };

        System.out.println(password.toString());

        System.out.println(arrayList.get(2));
    }

    class CustomArrayList<T> {

        Object[] arr;

        int size;

        public void add(T t) {
            if (arr == null) {
                arr = new Object[2];
            } else if (size == arr.length - 1) {
                int newSize = ((arr.length * 3) / 2) + 1;
                arr = Arrays.copyOf(arr, newSize);
            }
            arr[size] = t;
            size++;
        }

        public T get(int position) {
            return (T) arr[position];
        }
    }
}
