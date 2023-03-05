package com.example.infleanjpalecture.order.domain;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.domain.Item;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderItem {

    @Id
    @GeneratedValue
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "order_price"))
    )
    private Money orderPrice;

    private int count;

    private OrderItem (Item item, Money orderPrice, int count) {
        setItem(item);
        this.orderPrice = orderPrice;
        this.count = count;
        item.subtractStock(count);
    }

    public static OrderItem create(Item item, Money orderPrice, int count) {
        return new OrderItem(item, orderPrice, count);
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void cancel() {
        item.addStock(count);
    }

    public Money getTotalPrice() {
        return orderPrice.multiply(count);
    }
}
