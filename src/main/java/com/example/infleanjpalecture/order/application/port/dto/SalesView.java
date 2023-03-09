package com.example.infleanjpalecture.order.application.port.dto;

import java.util.List;

public class SalesView {
    private final List<OrderMemberDto> orderMembers;
    private final List<OrderItemDto> orderItems;

    public SalesView(List<OrderMemberDto> orderMembers, List<OrderItemDto> orderItems) {
        this.orderMembers = orderMembers;
        this.orderItems = orderItems;
    }

    public List<OrderMemberDto> getOrderMembers() {
        return orderMembers;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }
}
