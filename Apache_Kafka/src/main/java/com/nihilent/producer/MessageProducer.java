package com.nihilent.producer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import com.nihilent.entity.Customer;
import com.nihilent.util.SerializationUtil;

public class MessageProducer implements Runnable {

    private int messageCount;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    public MessageProducer(int messageCount) {
        this.messageCount = messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public void sendMessage() {
        Producer producer = new KafkaProducer(getProperties());

        for (int i = 0; i < messageCount; i++) {
            Random randomNumber = new Random();
            int customerId = randomNumber.nextInt(Integer.MAX_VALUE);
            Customer customer = new Customer(
                    customerId, "IN_PROCESS", formatter.format(new Date()), null);
            JSONObject jsonObject = new JSONObject(customer);
            byte[] arr = null;
            try {
                arr = SerializationUtil.serialize(jsonObject.toString());
            } catch (IOException e) {
                System.out.println("Exception occurred in Serialization");
            }
            String topic = "kafka_topic";
            ProducerRecord data = new ProducerRecord(topic, arr);
            producer.send(data);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " sent " + messageCount
                + " messages successfully.");
        producer.close();
    }

    public Properties getProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.16.1.51:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        return props;
    }

    public void run() {
        sendMessage();
    }
}
