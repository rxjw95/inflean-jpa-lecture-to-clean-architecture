package com.example.infleanjpalecture.application.port.out;

import com.example.infleanjpalecture.domain.Member;

public interface MemberPersistPort {

    void persist(Member member);
}
