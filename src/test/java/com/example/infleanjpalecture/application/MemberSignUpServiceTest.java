package com.example.infleanjpalecture.application;

import com.example.infleanjpalecture.common.domain.Address;
import com.example.infleanjpalecture.member.application.port.dto.SignUpCommand;
import com.example.infleanjpalecture.member.application.port.in.MemberSignUpUseCase;
import com.example.infleanjpalecture.member.application.port.out.MemberLoadPort;
import com.example.infleanjpalecture.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class MemberSignUpServiceTest {

    @Autowired
    private MemberSignUpUseCase signUpUseCase;

    @Autowired
    private MemberLoadPort memberLoadPort;

    @Test
    void signUp() {
        SignUpCommand signUpCommand = new SignUpCommand("woogie", new Address("seoul", "gangnam", "123456"));

        Long memberId = signUpUseCase.signUp(signUpCommand);

        Member compareMember = memberLoadPort.loadOne(memberId);
        assertThat(compareMember.getName()).isEqualTo(signUpCommand.memberName());
    }

    @Test
    void duplication_Case() {
        SignUpCommand signUpCommandFirst = new SignUpCommand("woogie", new Address("seoul", "yongsan", "654321"));
        SignUpCommand signUpCommandSecond = new SignUpCommand("woogie", new Address("seoul", "gangnam", "123456"));

        assertThatThrownBy(() -> {
            signUpUseCase.signUp(signUpCommandFirst);
            signUpUseCase.signUp(signUpCommandSecond);
        }, "이미 존재하는 사용자입니다.");
    }
}