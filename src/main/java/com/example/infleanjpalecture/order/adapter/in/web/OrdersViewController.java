package com.example.infleanjpalecture.order.adapter.in.web;

import com.example.infleanjpalecture.order.application.port.dto.SalesView;
import com.example.infleanjpalecture.order.application.port.in.SalesLoadUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersViewController {

    private final SalesLoadUseCase salesLoadUseCase;

    public OrdersViewController(SalesLoadUseCase salesLoadUseCase) {
        this.salesLoadUseCase = salesLoadUseCase;
    }

    @GetMapping("/order")
    public String orderForm(Model model) {
        SalesView salesView = salesLoadUseCase.loadAll();

        model.addAttribute("members", salesView.getOrderMembers());
        model.addAttribute("items", salesView.getOrderItems());

        return "/order/orderForm";
    }
}
