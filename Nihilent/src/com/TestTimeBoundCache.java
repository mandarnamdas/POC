package com;

public class TestTimeBoundCache {

    public static void main(String[] args) {

        TimeBoundCache t = TimeBoundCache.getInstance();
        t.add(1, "hi");

        System.out.println(t.getCache());
    }

}
