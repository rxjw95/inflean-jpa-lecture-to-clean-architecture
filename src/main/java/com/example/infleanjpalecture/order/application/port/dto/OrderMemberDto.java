package com.example.infleanjpalecture.order.application.port.dto;


import lombok.Getter;

@Getter
public class OrderMemberDto {
    private final Long id;
    private final String name;

    public OrderMemberDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
