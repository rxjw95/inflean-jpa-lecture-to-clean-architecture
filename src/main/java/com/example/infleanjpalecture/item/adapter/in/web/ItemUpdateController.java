package com.example.infleanjpalecture.item.adapter.in.web;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.adapter.in.web.form.BookUpdateForm;
import com.example.infleanjpalecture.item.application.port.dto.UpdateItemCommand;
import com.example.infleanjpalecture.item.application.port.in.ItemUpdateUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemUpdateController {

    private final ItemUpdateUseCase itemUpdateUseCase;

    public ItemUpdateController(ItemUpdateUseCase itemUpdateUseCase) {
        this.itemUpdateUseCase = itemUpdateUseCase;
    }

    @GetMapping("/items/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model) {
        BookUpdateForm bookUpdateForm = new BookUpdateForm();
        bookUpdateForm.setId(id);
        model.addAttribute("form", bookUpdateForm);
        return "/items/updateItemForm";
    }

    @PostMapping("/items/{id}/edit")
    public String updateBook(@PathVariable Long id, BookUpdateForm bookUpdateForm) {

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(
                bookUpdateForm.getId(),
                bookUpdateForm.getName(),
                Money.from(bookUpdateForm.getPrice()),
                bookUpdateForm.getStockQuantity(),
                bookUpdateForm.getAuthor(),
                bookUpdateForm.getIsbn());

        itemUpdateUseCase.update(updateItemCommand);


        return "redirect:/items";
    }
}
