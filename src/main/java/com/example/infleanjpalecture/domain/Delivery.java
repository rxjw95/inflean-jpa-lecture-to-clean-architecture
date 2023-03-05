package com.example.infleanjpalecture.domain;

import com.example.infleanjpalecture.common.domain.Address;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Delivery {

    @Id
    @GeneratedValue
    private Long deliveryId;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrder(Order order) {
        this.order = order;
    }
}
