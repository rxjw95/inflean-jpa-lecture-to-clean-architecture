package com.example.infleanjpalecture.order.application.port.out;

import com.example.infleanjpalecture.order.domain.Order;

public interface OrderLoadPort {

    Order loadOne(Long orderId);

//    List<Order> load(OrderSearchSpec searchSpec);
}
