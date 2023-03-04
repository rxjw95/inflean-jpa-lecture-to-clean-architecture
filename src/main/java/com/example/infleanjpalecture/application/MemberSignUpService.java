package com.example.infleanjpalecture.application;

import com.example.infleanjpalecture.application.port.in.MemberSignUpUseCase;
import com.example.infleanjpalecture.application.port.dto.SignUpCommand;
import com.example.infleanjpalecture.application.port.out.MemberLoadPort;
import com.example.infleanjpalecture.application.port.out.MemberPersistPort;
import com.example.infleanjpalecture.domain.Member;
import com.example.infleanjpalecture.exception.DuplicateMemberNameException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSignUpService implements MemberSignUpUseCase {

    private final MemberLoadPort memberLoadPort;
    private final MemberPersistPort memberPersistPort;

    public MemberSignUpService(MemberLoadPort memberLoadPort, MemberPersistPort memberPersistPort) {
        this.memberLoadPort = memberLoadPort;
        this.memberPersistPort = memberPersistPort;
    }

    @Transactional
    @Override
    public Long signUp(SignUpCommand command) {
        validateDuplication(command);
        Member member = new Member(command.memberName(), command.address());
        memberPersistPort.persist(member);
        return member.getMemberId();
    }

    private void validateDuplication(SignUpCommand command) {
        List<Member> members = memberLoadPort.loadMemberByName(command.memberName());
        if(!members.isEmpty()) {
            throw new DuplicateMemberNameException();
        }
    }
}
