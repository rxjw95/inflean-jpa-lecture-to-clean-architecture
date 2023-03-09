package com.example.infleanjpalecture.order.application.port.dto;

import com.example.infleanjpalecture.order.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderQuery {

    private String memberName;
    private OrderStatus orderStatus;
}
