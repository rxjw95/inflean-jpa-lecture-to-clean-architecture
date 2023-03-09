package com.example.infleanjpalecture.item.application;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.application.port.dto.BookDto;
import com.example.infleanjpalecture.item.application.port.dto.RegisterBookCommand;
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
        RegisterBookCommand command = new RegisterBookCommand("Test Driven Development", Money.from(18000), 10, "uncle bob", "123456");
        Book book = new Book(command.name(), command.price(), command.stockQuantity(), command.author(), command.isbn());
        itemPersistPort.persist(book);

        BookDto bookDto = itemLoadUseCase.loadItem(book.getItemId());

        assertThat(bookDto.name()).isEqualTo("Test Driven Development");
    }

    @Test
    void loadAll() {
        RegisterBookCommand command = new RegisterBookCommand("Test Driven Development", Money.from(18000), 10, "uncle bob", "123456");
        Book book = new Book(command.name(), command.price(), command.stockQuantity(), command.author(), command.isbn());
        itemPersistPort.persist(book);

        List<BookDto> bookDtos = itemLoadUseCase.loadItems();

        assertThat(bookDtos.size()).isEqualTo(1);
        assertThat(bookDtos.get(0).name()).isEqualTo("Test Driven Development");
    }

}