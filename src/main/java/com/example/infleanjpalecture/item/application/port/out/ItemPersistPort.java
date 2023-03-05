package com.example.infleanjpalecture.item.application.port.out;

import com.example.infleanjpalecture.item.domain.Item;

public interface ItemPersistPort {

    void persist(Item item);
}
