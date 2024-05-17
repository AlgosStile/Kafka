package org.example.kafka;

import org.example.kafka.controller.MsgController;
import org.example.kafka.dto.Address;
import org.example.kafka.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class KafkaApplicationTests {

    @Mock
    private KafkaTemplate<Long, UserDto> kafkaTemplate;

    @InjectMocks
    private MsgController msgController;

    @Test
    public void testSendMessageSuccess() {
        UserDto userDto = new UserDto(25L, "Alice", new Address("USA", "New York", "Broadway", 123L, 4L));

        when(kafkaTemplate.send(anyString(), anyLong(), any(UserDto.class))).thenReturn((CompletableFuture<SendResult<Long, UserDto>>) mock(ListenableFuture.class));

        msgController.sendMessage(userDto);

        verify(kafkaTemplate, times(1)).send(anyString(), anyLong(), eq(userDto));
    }

    @Test
    public void testSendMessageFailure() {
        UserDto userDto = new UserDto(30L, "Bob", new Address("UK", "London", "Oxford Street", 456L, 7L));
        RuntimeException exception = new RuntimeException("Simulating failure");

        when(kafkaTemplate.send(anyString(), anyLong(), any(UserDto.class))).thenThrow(exception);

        msgController.sendMessage(userDto);

        verify(kafkaTemplate, times(1)).send(anyString(), anyLong(), eq(userDto));
    }

}