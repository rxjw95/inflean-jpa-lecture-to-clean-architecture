package com.example.infleanjpalecture.member.application.usecase.in;

import com.example.infleanjpalecture.member.application.dto.SignUpCommand;

public interface MemberSignUpUseCase {

    Long signUp(SignUpCommand member);
}
