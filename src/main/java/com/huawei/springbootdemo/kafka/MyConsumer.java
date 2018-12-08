package com.huawei.springbootdemo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class MyConsumer extends Thread {
    private String topic;
    private KafkaConsumer<String, String> consumer;


    public MyConsumer(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KafkaProperties.BROKER);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id","demogroup");
        consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(KafkaProperties.TOPIC));
    }

    @Override
    public void run(){
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("RecordOffset:" + consumerRecord.offset() + "  RecordValue:" + consumerRecord.value());
            }
        }
    }

    public static void main(String[] args) {
        new MyConsumer().start();
    }
}
