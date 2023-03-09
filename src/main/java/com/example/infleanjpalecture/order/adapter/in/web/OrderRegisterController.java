package com.example.infleanjpalecture.order.adapter.in.web;

import com.example.infleanjpalecture.order.application.port.in.OrderRegisterUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderRegisterController {

    private final OrderRegisterUseCase orderRegisterUseCase;

    public OrderRegisterController(OrderRegisterUseCase orderRegisterUseCase) {
        this.orderRegisterUseCase = orderRegisterUseCase;
    }

    @PostMapping("/order")
    public String order(@ModelAttribute OrderForm orderForm) {

        orderRegisterUseCase.order(orderForm.getMemberId(), orderForm.getItemId(), orderForm.getCount());
        return "redirect:/orders";
    }
}
