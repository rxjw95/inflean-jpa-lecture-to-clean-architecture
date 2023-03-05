package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.order.application.port.in.OrderCancelUseCase;
import com.example.infleanjpalecture.order.application.port.out.OrderLoadPort;
import com.example.infleanjpalecture.order.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderCancelService implements OrderCancelUseCase {

    private final OrderLoadPort orderLoadPort;

    public OrderCancelService(OrderLoadPort orderLoadPort) {
        this.orderLoadPort = orderLoadPort;

    }


    @Override
    public void cancel(Long orderId) {
        Order order = orderLoadPort.loadOne(orderId);
        order.cancel();
    }
}
