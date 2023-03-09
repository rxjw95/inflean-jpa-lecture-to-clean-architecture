package com.example.infleanjpalecture.order.adapter.out.persistence;

import com.example.infleanjpalecture.order.application.port.dto.OrderQuery;
import com.example.infleanjpalecture.order.application.port.out.OrderLoadPort;
import com.example.infleanjpalecture.order.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderLoadAdapter implements OrderLoadPort {

    @PersistenceContext
    private EntityManager entityManager;


    public Order loadOne(Long orderId) {
        return entityManager.find(Order.class, orderId);
    }

    public List<Order> loadBySearch(OrderQuery orderQuery) {
        if((orderQuery.getMemberName() == null || orderQuery.getMemberName().isEmpty()) && orderQuery.getOrderStatus() == null) {
            return entityManager
                    .createQuery("select o from Order o join fetch o.member join fetch o.orderItems", Order.class)
                    .getResultList();
        }

        if(orderQuery.getOrderStatus() == null) {
            return entityManager.createQuery("select o from Order o join fetch o.member join fetch o.orderItems where o.member.name = :memberName", Order.class)
                    .setParameter("memberName", orderQuery.getMemberName())
                    .getResultList();
        }

        if(orderQuery.getMemberName() == null || orderQuery.getMemberName().isEmpty()) {
            return entityManager.createQuery("select o from Order o join fetch o.member join fetch o.orderItems where o.status = :status", Order.class)
                    .setParameter("status", orderQuery.getOrderStatus())
                    .getResultList();
        }

        return entityManager.createQuery("select o from Order o join fetch o.member join fetch o.orderItems where o.member.name = :memberName and o.status = :status", Order.class)
                .setParameter("memberName", orderQuery.getMemberName())
                .setParameter("status", orderQuery.getOrderStatus())
                .getResultList();
    }
}
