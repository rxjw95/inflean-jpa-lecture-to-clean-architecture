package com.example.infleanjpalecture.adapter.out.persistence;

import com.example.infleanjpalecture.application.port.out.MemberPersistPort;
import com.example.infleanjpalecture.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberPersistenceAdapter implements MemberPersistPort {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Member member) {
        entityManager.persist(member);
    }
}
