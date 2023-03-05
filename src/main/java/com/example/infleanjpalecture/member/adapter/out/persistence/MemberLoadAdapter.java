package com.example.infleanjpalecture.member.adapter.out.persistence;

import com.example.infleanjpalecture.member.application.port.out.MemberLoadPort;
import com.example.infleanjpalecture.member.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberLoadAdapter implements MemberLoadPort {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member loadOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public List<Member> loadMemberByName(String name) {
        return entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Member> loadAll() {
        return entityManager.createQuery("select m from Member m", Member.class).getResultList();
    }
}
