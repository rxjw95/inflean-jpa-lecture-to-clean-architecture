package com.example.infleanjpalecture.order.application.port.out;

import com.example.infleanjpalecture.order.domain.Order;

public interface OrderPersistPort {

    void persist(Order order);
}
