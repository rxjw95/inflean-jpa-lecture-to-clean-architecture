package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.order.application.port.dto.OrderHistoryView;
import com.example.infleanjpalecture.order.application.port.dto.OrderQuery;
import com.example.infleanjpalecture.order.application.port.in.OrderHistoryLoadUseCase;
import com.example.infleanjpalecture.order.application.port.out.OrderLoadPort;
import com.example.infleanjpalecture.order.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderHistoryService implements OrderHistoryLoadUseCase {
    private final OrderLoadPort orderLoadPort;
    private final DtoConverter dtoConverter;

    public OrderHistoryService(OrderLoadPort orderLoadPort, DtoConverter dtoConverter) {
        this.orderLoadPort = orderLoadPort;
        this.dtoConverter = dtoConverter;
    }

    @Override
    @Transactional
    public List<OrderHistoryView> loadOrderHistory(OrderQuery query) {
        List<Order> orders = orderLoadPort.loadBySearch(query);
        List<OrderHistoryView> orderHistoryViews = dtoConverter.toOrderHistoryViews(orders);
        return orderHistoryViews;
    }
}
