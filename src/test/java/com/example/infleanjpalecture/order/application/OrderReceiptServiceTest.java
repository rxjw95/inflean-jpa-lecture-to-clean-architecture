package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.common.domain.Address;
import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.exception.NotEnoughStockException;
import com.example.infleanjpalecture.item.application.port.out.ItemPersistPort;
import com.example.infleanjpalecture.item.domain.Book;
import com.example.infleanjpalecture.member.application.usecase.out.MemberPersistPort;
import com.example.infleanjpalecture.member.domain.Member;
import com.example.infleanjpalecture.order.application.port.in.OrderRegisterUseCase;
import com.example.infleanjpalecture.order.application.port.out.OrderLoadPort;
import com.example.infleanjpalecture.order.domain.Order;
import com.example.infleanjpalecture.order.domain.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@Transactional
class OrderReceiptServiceTest {

    @Autowired
    private OrderRegisterUseCase orderRegisterUseCase;

    @Autowired
    private OrderLoadPort orderLoadPort;

    @Autowired
    private MemberPersistPort memberPersistPort;

    @Autowired
    private ItemPersistPort itemPersistPort;

    @Test
    void 주문을_접수하면_상태는_ORDER() {

        Member member = new Member("woogie", new Address("seoul", "gangnam", "123456"));
        memberPersistPort.persist(member);

        Book book = new Book("Test Driven Development", new Money(18000), 10, "uncle bob", "123456");
        itemPersistPort.persist(book);

        Long orderId = orderRegisterUseCase.order(member.getMemberId(), book.getItemId(), 2);
        Order order = orderLoadPort.loadOne(orderId);

        assertThat(order.getStatus()).isEqualTo(OrderStatus.ORDER);
    }

    @Test
    void 주문을_접수하면_아이템의_재고가_주문_개수에_맞게_줄어든다() {
        Member member = new Member("woogie", new Address("seoul", "gangnam", "123456"));
        memberPersistPort.persist(member);

        Book book = new Book("Test Driven Development", new Money(18000), 10, "uncle bob", "123456");
        itemPersistPort.persist(book);

        orderRegisterUseCase.order(member.getMemberId(), book.getItemId(), 2);

        assertThat(book.getStockQuantity()).isEqualTo(8);
    }

    @Test
    void 주문_개수에_맞는_총가격을_얻을_수_있다() {
        Member member = new Member("woogie", new Address("seoul", "gangnam", "123456"));
        memberPersistPort.persist(member);

        Book book = new Book("Test Driven Development", new Money(18000), 10, "uncle bob", "123456");
        itemPersistPort.persist(book);

        Long orderId = orderRegisterUseCase.order(member.getMemberId(), book.getItemId(), 2);
        Order order = orderLoadPort.loadOne(orderId);

        assertThat(order.getTotalPrice()).isEqualTo(new Money(36000));
    }

    @Test
    void 주문_수량이_재고_수량보다_많이_주문하면_NotEnoughStockException() {
        Member member = new Member("woogie", new Address("seoul", "gangnam", "123456"));
        memberPersistPort.persist(member);

        Book book = new Book("Test Driven Development", new Money(18000), 1, "uncle bob", "123456");
        itemPersistPort.persist(book);

        assertThatExceptionOfType(NotEnoughStockException.class)
                .isThrownBy(() -> orderRegisterUseCase.order(member.getMemberId(), book.getItemId(), 2))
                .withMessage("재고가 부족합니다.");

    }
}