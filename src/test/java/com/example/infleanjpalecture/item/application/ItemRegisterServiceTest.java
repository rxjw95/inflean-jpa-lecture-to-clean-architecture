package com.example.infleanjpalecture.item.application;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.application.port.dto.RegisterBookCommand;
import com.example.infleanjpalecture.item.application.port.in.ItemRegisterUseCase;
import com.example.infleanjpalecture.item.application.port.out.ItemLoadPort;
import com.example.infleanjpalecture.item.domain.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ItemRegisterServiceTest {

    @Autowired
    private ItemRegisterUseCase itemRegisterUseCase;

    @Autowired
    private ItemLoadPort itemLoadPort;

    @Test
    void persist() {
        RegisterBookCommand registerBookCommand = new RegisterBookCommand("Test Driven Development", Money.from(18000), 10, "uncle bob", "123456");

        Long itemId = itemRegisterUseCase.register(registerBookCommand);
        Item item = itemLoadPort.loadOne(itemId);

        Assertions.assertThat(item.getName()).isEqualTo("Test Driven Development");
    }
}