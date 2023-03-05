package com.example.infleanjpalecture.item.application;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.application.port.dto.ItemDto;
import com.example.infleanjpalecture.item.application.port.dto.ItemRegisterCommand;
import com.example.infleanjpalecture.item.application.port.in.ItemLoadUseCase;
import com.example.infleanjpalecture.item.application.port.out.ItemPersistPort;
import com.example.infleanjpalecture.item.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemLoadServiceTest {

    @Autowired
    ItemLoadUseCase itemLoadUseCase;

    @Autowired
    ItemPersistPort itemPersistPort;

    @Test
    void loadOne() {
        ItemRegisterCommand command = new ItemRegisterCommand("Test Driven Development", 18000, 10, "uncle bob", "123456");
        Book book = new Book(command.name(), new Money(command.price()), command.stockQuantity(), command.author(), command.isbn());
        itemPersistPort.persist(book);

        ItemDto itemDto = itemLoadUseCase.loadItem(book.getItemId());

        assertThat(itemDto.getName()).isEqualTo("Test Driven Development");
    }

    @Test
    void loadAll() {
        ItemRegisterCommand command = new ItemRegisterCommand("Test Driven Development", 18000, 10, "uncle bob", "123456");
        Book book = new Book(command.name(), new Money(command.price()), command.stockQuantity(), command.author(), command.isbn());
        itemPersistPort.persist(book);

        List<ItemDto> itemDtos = itemLoadUseCase.loadItems();

        assertThat(itemDtos.size()).isEqualTo(1);
        assertThat(itemDtos.get(0).getName()).isEqualTo("Test Driven Development");
    }

}