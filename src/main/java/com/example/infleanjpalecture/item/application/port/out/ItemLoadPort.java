package com.example.infleanjpalecture.item.application.port.out;

import com.example.infleanjpalecture.item.domain.Item;

import java.util.List;

public interface ItemLoadPort {

    Item loadOne(Long id);

    List<Item> loadAll();
}
