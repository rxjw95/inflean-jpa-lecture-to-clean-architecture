package com.example.infleanjpalecture.item.application;

import com.example.infleanjpalecture.item.application.port.DomainToDtoConverter;
import com.example.infleanjpalecture.item.application.port.dto.BookDto;
import com.example.infleanjpalecture.item.application.port.in.ItemLoadUseCase;
import com.example.infleanjpalecture.item.application.port.out.ItemLoadPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemLoadService implements ItemLoadUseCase {

    private final ItemLoadPort itemLoadPort;
    private final DomainToDtoConverter converter;

    public ItemLoadService(ItemLoadPort itemLoadPort, DomainToDtoConverter converter) {
        this.itemLoadPort = itemLoadPort;
        this.converter = converter;
    }

    @Override
    public List<BookDto> loadItems() {
        List<BookDto> bookDtos = converter.toBookDtos(itemLoadPort.loadAll());
        return bookDtos;
    }

    @Override
    public BookDto loadItem(Long itemId) {
        return converter.toBookDto(itemLoadPort.loadOne(itemId));
    }
}
