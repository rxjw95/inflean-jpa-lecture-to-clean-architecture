package com.example.infleanjpalecture.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public abstract class Item {
    @Id
    @GeneratedValue
    private Long itemId;

    private String name;
    private Money price;
    private 

}
