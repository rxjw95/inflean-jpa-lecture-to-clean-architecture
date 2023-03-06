package com.example.infleanjpalecture.member.application.port.in;

import com.example.infleanjpalecture.member.application.port.dto.MemberDto;

import java.util.List;

public interface MemberLoadUseCase {

    List<MemberDto> loadAll();
}
