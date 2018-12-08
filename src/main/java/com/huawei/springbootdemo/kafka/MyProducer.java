package com.huawei.springbootdemo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer extends Thread {
    private String topic;
    private KafkaProducer<String, String> kafkaProducer;

    public MyProducer(String topic) {
        this.topic = topic;
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KafkaProperties.BROKER);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<String, String>(properties);
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true) {
            String message = "message_" + messageNo;
            System.out.println("Sending: " + message);
            kafkaProducer.send(new ProducerRecord<>(this.topic, message));
            messageNo++;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyProducer(KafkaProperties.TOPIC).start();
    }
}
