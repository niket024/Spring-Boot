package com.nik;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import com.nik.config.SomeBean;

public class MyConsumerInterceptor implements ConsumerInterceptor<String, String> {

    private SomeBean bean;

    @Override
    public void configure(Map<String, ?> configs) {
        this.bean = (SomeBean) configs.get("some.bean");
    }

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        this.bean.someMethod("consumer interceptor");
        return records;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
    }

    @Override
    public void close() {
    }

}
