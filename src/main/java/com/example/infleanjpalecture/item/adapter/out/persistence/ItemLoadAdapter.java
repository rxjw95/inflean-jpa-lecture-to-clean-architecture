package com.example.infleanjpalecture.item.adapter.out.persistence;

import com.example.infleanjpalecture.item.application.port.out.ItemLoadPort;
import com.example.infleanjpalecture.item.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemLoadAdapter implements ItemLoadPort {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Book loadOne(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> loadAll() {
        return entityManager.createQuery("select i from Book i", Book.class).getResultList();
    }
}
