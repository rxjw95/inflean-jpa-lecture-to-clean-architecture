package com.example.infleanjpalecture.member.application.port.out;

import com.example.infleanjpalecture.member.domain.Member;

import java.util.List;

public interface MemberLoadPort {

    Member loadOne(Long id);

    List<Member> loadMemberByName(String name);

    List<Member> loadAll();
}
