package com.nihilent.consumer;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.DatabaseEnum;
import com.nihilent.database.DatabaseOperations;
import com.nihilent.database.MongoDBOperations;
import com.nihilent.database.MySqlDatabaseOperations;
import com.nihilent.database.SqlDatabaseOperations;
import com.nihilent.entity.Customer;
import com.nihilent.util.SerializationUtil;

public class MessageConsumer implements Runnable {

    private final AtomicBoolean closed = new AtomicBoolean(false);
    private Consumer consumer = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    private DatabaseEnum database;

    public MessageConsumer() {
        System.out.println(this.hashCode());
    }

    public void consume() {
        consumer = new KafkaConsumer(getProperties());
        System.out.println("consumer hashcode : " + consumer.hashCode());
        DatabaseOperations operations = null;
        if (database == DatabaseEnum.MYSQL) {
            operations = new MySqlDatabaseOperations();
        } else if (database == DatabaseEnum.MONGODB) {
            operations = new MongoDBOperations();
        } else if (database == DatabaseEnum.SQL) {
            operations = new SqlDatabaseOperations();
        }
        consumer.subscribe(Arrays.asList("kafka_topic"));
        try {
            while (!closed.get()) {
                ConsumerRecords<String, byte[]> records = consumer.poll(100);
                for (ConsumerRecord<String, byte[]> record : records) {
                    Customer customer = null;
                    JSONObject jsonObject = null;
                    jsonObject = new JSONObject(
                            (String) SerializationUtil.deserialize(record.value()));
                    ObjectMapper mapper = new ObjectMapper();
                    customer = mapper.readValue(jsonObject.toString(), Customer.class);
                    // System.out.printf(
                    // "thread = %s, offset = %d, customerId = %d, status = %s \n",
                    // Thread.currentThread().getName(), record.offset(),
                    // customer.getCustomerId(), customer.getStatus());
                    customer.setStatus("PROCESSED");
                    customer.setEndTime(formatter.format(new Date()));
                    operations.saveCustomer(customer);
                    consumer.commitSync();
                }
                if (records != null && records.count() > 0) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " processed "
                            + records.count() + " records.");
                }
                operations.closeConnections();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in Message Consumer : " + e.getMessage());
        } finally {
            System.out.println("Closing Thread : " + Thread.currentThread().getName());
            consumer.unsubscribe();
            consumer.close();
            consumer = null;
        }
    }

    private Properties getProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.16.1.51:9092");
        props.put("group.id", "nihilent");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        // props.put("zookeeper.session.timeout.ms", "6000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put(
                "value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        // props.put("auto.offset.reset", "earliest");
        return props;
    }

    public void run() {
        closed.set(false);
        consume();
    }

    public void stopConsumer() {
        closed.set(true);
        if (consumer != null) {
            consumer.wakeup();
        }
    }

    public void setDatabase(DatabaseEnum database) {
        this.database = database;
    }
}
