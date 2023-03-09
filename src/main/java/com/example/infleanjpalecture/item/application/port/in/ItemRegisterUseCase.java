package com.example.infleanjpalecture.item.application.port.in;

import com.example.infleanjpalecture.item.application.port.dto.RegisterBookCommand;

public interface ItemRegisterUseCase {

    Long register(RegisterBookCommand command);
}
