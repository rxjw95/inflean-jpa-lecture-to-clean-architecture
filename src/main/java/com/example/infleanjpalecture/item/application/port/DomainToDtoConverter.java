package com.example.infleanjpalecture.item.application.port;

import com.example.infleanjpalecture.item.application.port.dto.ItemDto;
import com.example.infleanjpalecture.item.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainToDtoConverter {

    public ItemDto toItemDto(Item item) {
        return new ItemDto(item.getItemId(), item.getName(), item.getPrice(), item.getStockQuantity());
    }

    public List<ItemDto> toItemDtos(List<Item> items) {
        return items.stream().map(this::toItemDto).toList();
    }
}
