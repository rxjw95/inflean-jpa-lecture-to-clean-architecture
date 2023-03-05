package com.example.infleanjpalecture.item.application;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.application.port.dto.ItemRegisterCommand;
import com.example.infleanjpalecture.item.application.port.in.ItemRegisterUseCase;
import com.example.infleanjpalecture.item.application.port.out.ItemPersistPort;
import com.example.infleanjpalecture.item.domain.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemRegisterService implements ItemRegisterUseCase {

    private final ItemPersistPort itemPersistPort;

    public ItemRegisterService(ItemPersistPort itemPersistPort) {
        this.itemPersistPort = itemPersistPort;
    }

    @Override
    @Transactional
    public Long register(ItemRegisterCommand command) {
        Book book = new Book(command.name(), new Money(command.price()), command.stockQuantity(), command.author(), command.isbn());
        itemPersistPort.persist(book);
        return book.getItemId();
    }
}
