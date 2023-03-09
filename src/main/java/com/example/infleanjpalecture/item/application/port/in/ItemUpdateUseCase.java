package com.example.infleanjpalecture.item.application.port.in;

import com.example.infleanjpalecture.item.application.port.dto.UpdateItemCommand;

public interface ItemUpdateUseCase {

    void update(UpdateItemCommand updateItemCommand);
}
