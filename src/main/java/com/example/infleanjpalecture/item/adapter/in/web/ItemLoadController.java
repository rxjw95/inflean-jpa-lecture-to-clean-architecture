package com.example.infleanjpalecture.item.adapter.in.web;

import com.example.infleanjpalecture.item.application.port.dto.BookDto;
import com.example.infleanjpalecture.item.application.port.in.ItemLoadUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemLoadController {
    private final ItemLoadUseCase itemLoadUseCase;

    public ItemLoadController(ItemLoadUseCase itemLoadUseCase) {
        this.itemLoadUseCase = itemLoadUseCase;
    }

    @GetMapping("/items")
    public String itemList(Model model) {
        List<BookDto> bookDtos = itemLoadUseCase.loadItems();
        model.addAttribute("items", bookDtos);
        return "items/itemList";
    }
}
