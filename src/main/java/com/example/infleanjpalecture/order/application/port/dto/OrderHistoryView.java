package com.example.infleanjpalecture.order.application.port.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderHistoryView {
    private final Long id;
    private final String memberName;
    private final String itemName;
    private final int orderPrice;
    private final int count;
    private final String status;
    private final LocalDateTime orderDate;

    public OrderHistoryView(Long id, String memberName, String itemName, int orderPrice, int count, String status, LocalDateTime orderDate) {
        this.id = id;
        this.memberName = memberName;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.count = count;
        this.status = status;
        this.orderDate = orderDate;
    }
}
