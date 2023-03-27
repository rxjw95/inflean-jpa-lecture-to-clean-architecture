package com.example.infleanjpalecture.member.application.usecase.out;

import com.example.infleanjpalecture.member.domain.Member;

public interface MemberPersistPort {

    void persist(Member member);
}
