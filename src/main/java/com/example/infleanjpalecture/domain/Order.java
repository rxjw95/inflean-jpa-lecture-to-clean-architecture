package com.example.infleanjpalecture.domain;

import com.example.infleanjpalecture.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
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

    public void addMember(Member member) {
        this.member = member;
        this.member.getOrders().add(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        this.delivery.setOrder(this);
    }

}
