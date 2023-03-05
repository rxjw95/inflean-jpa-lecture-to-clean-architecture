package com.example.infleanjpalecture.item.application.port.dto;

import com.example.infleanjpalecture.common.domain.Money;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class ItemDto {

    private final Long itemId;
    private final String name;
    private final Money price;
    private final int stockQuantity;

    public ItemDto(Long itemId, String name, Money price, int stockQuantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
