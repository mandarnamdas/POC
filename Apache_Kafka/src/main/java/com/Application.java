package com;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nihilent.consumer.MessageConsumer;
import com.nihilent.producer.MessageProducer;

public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExecutorService producerThreads = Executors.newFixedThreadPool(500);
        ExecutorService consumerThreads = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            producerThreads.execute(new MessageProducer(10));
        }

        producerThreads.shutdown();

        while (!producerThreads.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Finished all producer threads in : " + (endTime - startTime)
                + " milliseconds");
        for (int i = 0; i < 10; i++) {
            consumerThreads.execute(new MessageConsumer());
        }
        consumerThreads.shutdown();

        while (!consumerThreads.isTerminated()) {
        }
    }
}
