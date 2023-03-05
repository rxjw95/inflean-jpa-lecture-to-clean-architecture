package com.example.infleanjpalecture.item.adapter.out.persistence;

import com.example.infleanjpalecture.item.application.port.out.ItemPersistPort;
import com.example.infleanjpalecture.item.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ItemPersistAdapter implements ItemPersistPort {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void persist(Item item) {
        if(item.getItemId() == null) {
            entityManager.persist(item);
        } else {
            entityManager.merge(item);
        }
    }
}
