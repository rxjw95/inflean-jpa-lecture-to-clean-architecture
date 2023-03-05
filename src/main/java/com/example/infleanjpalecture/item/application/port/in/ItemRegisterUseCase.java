package com.example.infleanjpalecture.item.application.port.in;

import com.example.infleanjpalecture.item.application.port.dto.ItemRegisterCommand;

public interface ItemRegisterUseCase {

    Long register(ItemRegisterCommand command);
}
