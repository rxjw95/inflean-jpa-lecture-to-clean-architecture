package com.example.infleanjpalecture.domain.item;

import com.example.infleanjpalecture.domain.Category;
import com.example.infleanjpalecture.domain.Money;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public abstract class Item {
    @Id
    @GeneratedValue
    private Long itemId;

    private String name;
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "price"))
    )
    private Money price;
    private int stockQuantity;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();
}
