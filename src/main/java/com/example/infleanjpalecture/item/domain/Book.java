package com.example.infleanjpalecture.item.domain;

import com.example.infleanjpalecture.common.domain.Money;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book extends Item{

    private String author;
    private String isbn;

    public Book(String name, Money price, int stockQuantity, String author, String isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
