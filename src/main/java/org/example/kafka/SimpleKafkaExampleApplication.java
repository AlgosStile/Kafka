package org.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Главный класс приложения Spring Boot для простого примера Kafka.
 */
@SpringBootApplication
public class SimpleKafkaExampleApplication {

	/**
	 * Метод слушателя Kafka для обработки входящих сообщений из темы 'msg'.
	 *
	 * @param msg Входящее сообщение для обработки.
	 */
	@KafkaListener(topics = "msg")
	public void msgListener(String msg) {
		System.out.println("Received message: " + msg);
	}

	/**
	 * Главный метод для запуска приложения Spring Boot.
	 *
	 * @param args Параметры командной строки.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SimpleKafkaExampleApplication.class, args);
	}
}