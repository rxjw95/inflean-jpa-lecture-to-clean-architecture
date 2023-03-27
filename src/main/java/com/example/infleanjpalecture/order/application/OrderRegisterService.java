package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.item.application.port.out.ItemLoadPort;
import com.example.infleanjpalecture.item.domain.Item;
import com.example.infleanjpalecture.member.application.usecase.out.MemberLoadPort;
import com.example.infleanjpalecture.member.domain.Member;
import com.example.infleanjpalecture.order.application.port.in.OrderRegisterUseCase;
import com.example.infleanjpalecture.order.application.port.out.OrderPersistPort;
import com.example.infleanjpalecture.order.domain.Delivery;
import com.example.infleanjpalecture.order.domain.Order;
import com.example.infleanjpalecture.order.domain.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderRegisterService implements OrderRegisterUseCase {

    private final OrderPersistPort orderPersistPort;
    private final MemberLoadPort memberLoadPort;
    private final ItemLoadPort itemLoadPort;

    public OrderRegisterService(OrderPersistPort orderPersistPort, MemberLoadPort memberLoadPort, ItemLoadPort itemLoadPort) {
        this.orderPersistPort = orderPersistPort;
        this.memberLoadPort = memberLoadPort;
        this.itemLoadPort = itemLoadPort;
    }

    @Override
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberLoadPort.loadOne(memberId);
        Item item = itemLoadPort.loadOne(itemId);

        Delivery delivery = new Delivery(member.getAddress());

        OrderItem orderItem = OrderItem.create(item, item.getPrice(), count);

        Order order = Order.receipt(member, delivery, List.of(orderItem), LocalDateTime.now());
        orderPersistPort.persist(order);

        return order.getOrderId();
    }

}
