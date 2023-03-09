package com.example.infleanjpalecture.order.application.port.in;

import com.example.infleanjpalecture.order.application.port.dto.OrderHistoryView;
import com.example.infleanjpalecture.order.application.port.dto.OrderQuery;

import java.util.List;

public interface OrderHistoryLoadUseCase {

    List<OrderHistoryView> loadOrderHistory(OrderQuery query);

}
