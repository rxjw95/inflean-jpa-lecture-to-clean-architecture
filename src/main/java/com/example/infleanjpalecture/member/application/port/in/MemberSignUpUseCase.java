package com.example.infleanjpalecture.member.application.port.in;

import com.example.infleanjpalecture.member.application.port.dto.SignUpCommand;

public interface MemberSignUpUseCase {

    Long signUp(SignUpCommand member);
}
