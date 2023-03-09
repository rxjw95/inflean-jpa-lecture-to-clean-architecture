package com.example.infleanjpalecture.item.application.port.in;

import com.example.infleanjpalecture.item.application.port.dto.BookDto;

import java.util.List;

public interface ItemLoadUseCase {

    List<BookDto> loadItems();

    BookDto loadItem(Long itemId);
}
