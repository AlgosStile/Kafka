package org.example.kafka.controller;

import org.example.kafka.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для обработки сообщений.
 */
@RestController
@RequestMapping("msg")
public class MsgController {

    private final KafkaTemplate<Long, UserDto> kafkaTemplate;

    /**
     * Конструктор контроллера, инъектирующий KafkaTemplate.
     */
    @Autowired
    public MsgController(KafkaTemplate<Long, UserDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Метод для отправки сообщения в Kafka.
     *
     * @param userDto DTO пользователя для отправки сообщения.
     */
    @PostMapping
    public void sendMessage(@RequestBody UserDto userDto) {
        ListenableFuture<SendResult<Long, UserDto>> future = (ListenableFuture<SendResult<Long, UserDto>>) kafkaTemplate.send("topic_name", userDto.getAge(), userDto);

        future.addCallback(new ListenableFutureCallback<SendResult<Long, UserDto>>() {
            @Override
            public void onSuccess(SendResult<Long, UserDto> result) {
                System.out.println("Sent message=[" + userDto + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.err.println("Unable to send message=[" + userDto + "] due to : " + ex.getMessage());
            }
        });
    }
}