package com.example.infleanjpalecture.application.port.in;

import com.example.infleanjpalecture.application.port.dto.SignUpCommand;

public interface MemberSignUpUseCase {

    Long signUp(SignUpCommand member);
}
