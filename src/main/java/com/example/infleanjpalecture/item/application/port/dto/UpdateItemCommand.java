package com.example.infleanjpalecture.item.application.port.dto;

import com.example.infleanjpalecture.common.domain.Money;

public record UpdateItemCommand(
        Long id,
        String name,
        Money price,
        int stockQuantity,
        String author,
        String isbn)
{ }
