package com.example.infleanjpalecture.order.application.port.dto;

import lombok.Getter;

@Getter
public class OrderItemDto {
    private final Long id;
    private final String name;

    public OrderItemDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
