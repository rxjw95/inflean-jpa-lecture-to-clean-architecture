package com.example.infleanjpalecture.member.application.usecase.in;

import com.example.infleanjpalecture.member.application.dto.MemberDto;

import java.util.List;

public interface MemberLoadUseCase {

    List<MemberDto> loadAll();
}
