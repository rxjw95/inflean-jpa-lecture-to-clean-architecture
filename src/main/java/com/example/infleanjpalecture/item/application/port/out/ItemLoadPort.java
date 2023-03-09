package com.example.infleanjpalecture.item.application.port.out;

import com.example.infleanjpalecture.item.domain.Book;

import java.util.List;

public interface ItemLoadPort {

    Book loadOne(Long id);

    List<Book> loadAll();
}
