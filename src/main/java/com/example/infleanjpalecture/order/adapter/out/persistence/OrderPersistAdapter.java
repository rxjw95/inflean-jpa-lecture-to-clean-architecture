package com.example.infleanjpalecture.order.adapter.out.persistence;

import com.example.infleanjpalecture.order.application.port.out.OrderPersistPort;
import com.example.infleanjpalecture.order.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderPersistAdapter implements OrderPersistPort {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Order order) {
        entityManager.persist(order);
    }
}
