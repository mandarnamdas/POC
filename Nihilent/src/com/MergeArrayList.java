package com;

import java.util.ArrayList;

public class MergeArrayList {

    public static void main(String[] args) {

        ArrayList<String> l1 = new ArrayList<String>();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");
        ArrayList<String> l2 = new ArrayList<String>();
        l2.add("a");
        l2.add("b");

        l1 = removeDuplicatesAndMerge(l1, l2);
        System.out.println(l1);
    }

    private static ArrayList<String> removeDuplicatesAndMerge(ArrayList<String> l1,
            ArrayList<String> l2) {
        l1.removeAll(l2);
        l1.addAll(l2);
        return l1;
    }
}
