package com.example.infleanjpalecture.order.adapter.out.persistence;

import com.example.infleanjpalecture.order.application.port.out.OrderLoadPort;
import com.example.infleanjpalecture.order.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLoadAdapter implements OrderLoadPort {

    @PersistenceContext
    private EntityManager entityManager;


    public Order loadOne(Long orderId) {
        return entityManager.find(Order.class, orderId);
    }


}
