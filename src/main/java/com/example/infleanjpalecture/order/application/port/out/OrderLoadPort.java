package com.example.infleanjpalecture.order.application.port.out;

import com.example.infleanjpalecture.order.application.port.dto.OrderQuery;
import com.example.infleanjpalecture.order.domain.Order;

import java.util.List;

public interface OrderLoadPort {

    Order loadOne(Long orderId);

    List<Order> loadBySearch(OrderQuery orderQuery);

}
