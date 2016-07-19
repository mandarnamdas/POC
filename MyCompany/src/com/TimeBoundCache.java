package com;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TimeBoundCache {

    private static TimeBoundCache instance = new TimeBoundCache();

    private final ConcurrentHashMap<Integer, String> cache = new ConcurrentHashMap<Integer, String>();

    private TimeBoundCache() {
        Thread t = new Thread(new DeleteCache());
        t.start();
    }

    public static TimeBoundCache getInstance() {
        return instance;
    }

    public void add(Integer key, String value) {
        cache.put(key, value);
    }

    public void remove(Integer key) {
        cache.remove(key);
    }

    class DeleteCache implements Runnable {

        public void run() {
            while (true) {
                // System.out.println("1111");
                // cache.clear();
                for (Entry<Integer, String> entry : cache.entrySet()) {
                    System.out.println(entry.getValue());
                }
            }

        }
    }

    public ConcurrentHashMap<Integer, String> getCache() {
        return cache;
    }

}
