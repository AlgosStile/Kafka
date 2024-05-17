package org.example.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long age;
    private String name;
    private Address address;

    public UserDto(long l, String bob, Address address) {
    }
}
