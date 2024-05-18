package org.example.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Структура данных, представляющая адрес.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String country;
    private String city;
    private String street;
    private Long homeNumber;
    private Long flatNumber;
}