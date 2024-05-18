package org.example.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Объект передачи данных, представляющий пользователя с возрастом, именем
 * и адресом.
 */
@Data
@NoArgsConstructor
public class UserDto {
    private Long age;
    private String name;
    private Address address;

    /**
     * Конструктор для инициализации объекта UserDto.
     */
    public UserDto(long l, String bob, Address address) {
    }
}