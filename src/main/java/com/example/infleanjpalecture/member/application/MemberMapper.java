package com.example.infleanjpalecture.member.application;

import com.example.infleanjpalecture.member.application.dto.MemberDto;
import com.example.infleanjpalecture.member.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberMapper {

    public List<MemberDto> mapToMemberDto(List<Member> members) {
        return members.stream().map(member -> new MemberDto(member.getName(), member.getAddress())).toList();
    }
}
