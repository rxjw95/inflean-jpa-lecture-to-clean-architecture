package com.example.infleanjpalecture.member.application;

import com.example.infleanjpalecture.member.application.port.dto.MemberDto;
import com.example.infleanjpalecture.member.application.port.in.MemberLoadUseCase;
import com.example.infleanjpalecture.member.application.port.out.MemberLoadPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberLoadService implements MemberLoadUseCase {
    private final MemberLoadPort memberLoadPort;
    private final MemberMapper memberMapper;

    public MemberLoadService(MemberLoadPort memberLoadPort, MemberMapper memberMapper) {
        this.memberLoadPort = memberLoadPort;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDto> loadAll() {
        return memberMapper.mapToMemberDto(memberLoadPort.loadAll());
    }
}
