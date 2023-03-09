package com.example.infleanjpalecture.item.application.port;

import com.example.infleanjpalecture.item.application.port.dto.BookDto;
import com.example.infleanjpalecture.item.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainToDtoConverter {

    public BookDto toBookDto(Book item) {
        return new BookDto(item.getItemId(), item.getName(), item.getPrice(), item.getStockQuantity(), item.getAuthor(), item.getIsbn());
    }

    public List<BookDto> toBookDtos(List<Book> items) {
        return items.stream().map(this::toBookDto).toList();
    }
}
