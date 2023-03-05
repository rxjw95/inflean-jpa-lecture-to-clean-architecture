package com.example.infleanjpalecture.order.domain;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.exception.DeliveryCompletedException;
import com.example.infleanjpalecture.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Order(Member member, Delivery delivery, List<OrderItem> orderItems, LocalDateTime orderDate) {
        addMember(member);
        setDelivery(delivery);
        orderItems.forEach(this::addOrderItem);
        status = OrderStatus.ORDER;
        this.orderDate = orderDate;
    }

    public static Order receipt(Member member, Delivery delivery, List<OrderItem> orderItems, LocalDateTime orderDate) {
        return new Order(member, delivery, orderItems, orderDate);
    }

    private void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    private void addMember(Member member) {
        this.member = member;
        this.member.addOrder(this);
    }

    private void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        this.delivery.setOrder(this);
    }

    public void cancel() {
        if(delivery.getStatus() == DeliveryStatus.COMP) {
            throw new DeliveryCompletedException();
        }

        status = OrderStatus.CANCEL;
        orderItems.forEach(OrderItem::cancel);
    }

    public Money getTotalPrice() {
        List<Money> moneyList = orderItems.stream()
                .map(OrderItem::getOrderPrice)
                .toList();
        return Money.sum(moneyList);
    }
}
