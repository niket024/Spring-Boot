package com.nik;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.nik.config.SomeBean;

public class MyProducerInterceptor implements ProducerInterceptor<String, String> {

	private SomeBean bean;

	@Override
	public void configure(Map<String, ?> configs) {
		this.bean = (SomeBean) configs.get("some.bean");
	}

	@Override
	public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
		this.bean.someMethod("producer interceptor");
		return record;
	}

	@Override
	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
	}

	@Override
	public void close() {
	}

}
