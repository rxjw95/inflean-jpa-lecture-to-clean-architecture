package com.example.infleanjpalecture.item.adapter.in.web.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateForm {
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;
}
