package com.example.infleanjpalecture.application.port.out;

import com.example.infleanjpalecture.domain.Member;

import java.util.List;

public interface MemberLoadPort {

    Member loadOne(Long id);

    List<Member> loadMemberByName(String name);

    List<Member> loadAll();
}
