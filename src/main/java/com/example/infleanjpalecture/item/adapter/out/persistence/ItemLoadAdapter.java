package com.example.infleanjpalecture.item.adapter.out.persistence;

import com.example.infleanjpalecture.item.application.port.out.ItemLoadPort;
import com.example.infleanjpalecture.item.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemLoadAdapter implements ItemLoadPort {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Item loadOne(Long id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public List<Item> loadAll() {
        return entityManager.createQuery("select i from Item i", Item.class).getResultList();
    }
}
