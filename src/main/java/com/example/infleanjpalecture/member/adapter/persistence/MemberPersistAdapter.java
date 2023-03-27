package com.example.infleanjpalecture.member.adapter.persistence;

import com.example.infleanjpalecture.member.application.usecase.out.MemberPersistPort;
import com.example.infleanjpalecture.member.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberPersistAdapter implements MemberPersistPort {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Member member) {
        entityManager.persist(member);
    }
}
