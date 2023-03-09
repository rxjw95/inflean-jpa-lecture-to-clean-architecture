package com.example.infleanjpalecture.order.adapter.in.web;

import com.example.infleanjpalecture.order.application.port.dto.OrderHistoryView;
import com.example.infleanjpalecture.order.application.port.dto.OrderQuery;
import com.example.infleanjpalecture.order.application.port.in.OrderHistoryLoadUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class OrderHistoryController {

    private final OrderHistoryLoadUseCase orderHistoryLoadUseCase;

    public OrderHistoryController(OrderHistoryLoadUseCase orderHistoryLoadUseCase) {
        this.orderHistoryLoadUseCase = orderHistoryLoadUseCase;
    }

    @GetMapping("/orders")
    public String orderHistory(@ModelAttribute("orderSearch") OrderQuery query, Model model) {
        List<OrderHistoryView> orderHistoryViews = orderHistoryLoadUseCase.loadOrderHistory(query);
        model.addAttribute("orders", orderHistoryViews);
        return "order/orderList";
    }
}
