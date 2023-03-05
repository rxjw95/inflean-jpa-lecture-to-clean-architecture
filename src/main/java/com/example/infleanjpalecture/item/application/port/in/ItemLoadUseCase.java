package com.example.infleanjpalecture.item.application.port.in;

import com.example.infleanjpalecture.item.application.port.dto.ItemDto;

import java.util.List;

public interface ItemLoadUseCase {

    List<ItemDto> loadItems();

    ItemDto loadItem(Long itemId);
}
