package com.example.infleanjpalecture.item.domain;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.domain.Category;
import com.example.infleanjpalecture.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public Item(String name, Money price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int quantity) {
        stockQuantity += quantity;
    }

    public void subtractStock(int quantity) {
        int restQuantity = stockQuantity - quantity;

        if(restQuantity < 0 ) {
            throw new NotEnoughStockException();
        }

        this.stockQuantity = restQuantity;
    }
}
