package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.common.domain.Address;
import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.application.port.out.ItemPersistPort;
import com.example.infleanjpalecture.item.domain.Book;
import com.example.infleanjpalecture.member.application.port.out.MemberPersistPort;
import com.example.infleanjpalecture.member.domain.Member;
import com.example.infleanjpalecture.order.application.port.in.OrderCancelUseCase;
import com.example.infleanjpalecture.order.application.port.out.OrderLoadPort;
import com.example.infleanjpalecture.order.application.port.out.OrderPersistPort;
import com.example.infleanjpalecture.order.domain.Delivery;
import com.example.infleanjpalecture.order.domain.Order;
import com.example.infleanjpalecture.order.domain.OrderItem;
import com.example.infleanjpalecture.order.domain.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
class OrderCancelServiceTest {

    @Autowired
    private OrderCancelUseCase orderCancelUseCase;

    @Autowired
    private OrderPersistPort orderPersistPort;

    @Autowired
    private OrderLoadPort orderLoadPort;

    @Autowired
    private MemberPersistPort memberPersistPort;

    @Autowired
    private ItemPersistPort itemPersistPort;

    @Test
    void 주문을_취소하면_상태는_CANCEL() {
        Member member = new Member("woogie", new Address("seoul", "gangnam", "123456"));
        memberPersistPort.persist(member);

        Book book = new Book("Test Driven Development", new Money(18000), 10, "uncle bob", "123456");
        itemPersistPort.persist(book);

        Delivery delivery = new Delivery(member.getAddress());

        OrderItem orderItem = OrderItem.create(book, book.getPrice(), 2);

        Order order = Order.receipt(member, delivery, List.of(orderItem), LocalDateTime.now());
        orderPersistPort.persist(order);

        order.cancel();

        Assertions.assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCEL);
    }

    @Test
    void 주문을_취소하면_Item의_개수가_다시_원복한다() {
        Member member = new Member("woogie", new Address("seoul", "gangnam", "123456"));
        memberPersistPort.persist(member);

        Book book = new Book("Test Driven Development", new Money(18000), 10, "uncle bob", "123456");
        itemPersistPort.persist(book);

        Delivery delivery = new Delivery(member.getAddress());

        OrderItem orderItem = OrderItem.create(book, book.getPrice(), 2);

        Order order = Order.receipt(member, delivery, List.of(orderItem), LocalDateTime.now());
        orderPersistPort.persist(order);


        order.cancel();

        Assertions.assertThat(book.getStockQuantity()).isEqualTo(10);

    }
}