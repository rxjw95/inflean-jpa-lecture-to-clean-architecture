package com.example.infleanjpalecture.item.application;

import com.example.infleanjpalecture.item.application.port.dto.RegisterBookCommand;
import com.example.infleanjpalecture.item.application.port.dto.UpdateItemCommand;
import com.example.infleanjpalecture.item.application.port.in.ItemRegisterUseCase;
import com.example.infleanjpalecture.item.application.port.in.ItemUpdateUseCase;
import com.example.infleanjpalecture.item.application.port.out.ItemPersistPort;
import com.example.infleanjpalecture.item.domain.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemRegisterService implements ItemRegisterUseCase, ItemUpdateUseCase {

    private final ItemPersistPort itemPersistPort;

    public ItemRegisterService(ItemPersistPort itemPersistPort) {
        this.itemPersistPort = itemPersistPort;
    }

    @Override
    @Transactional
    public Long register(RegisterBookCommand command) {
        Book book = new Book(command.name(), command.price(), command.stockQuantity(), command.author(), command.isbn());
        itemPersistPort.persist(book);
        return book.getItemId();
    }

    @Override
    @Transactional
    public void update(UpdateItemCommand updateItemCommand) {
        Book book = Book.withId(
                updateItemCommand.id(),
                updateItemCommand.name(),
                updateItemCommand.price(),
                updateItemCommand.stockQuantity(),
                updateItemCommand.author(),
                updateItemCommand.isbn());

        itemPersistPort.persist(book);
    }
}
