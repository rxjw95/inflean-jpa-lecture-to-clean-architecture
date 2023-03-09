package com.example.infleanjpalecture.item.adapter.in.web;

import com.example.infleanjpalecture.common.domain.Money;
import com.example.infleanjpalecture.item.adapter.in.web.form.BookForm;
import com.example.infleanjpalecture.item.application.port.dto.RegisterBookCommand;
import com.example.infleanjpalecture.item.application.port.in.ItemRegisterUseCase;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemRegisterController {

    private final ItemRegisterUseCase itemRegisterUseCase;

    public ItemRegisterController(ItemRegisterUseCase itemRegisterUseCase) {
        this.itemRegisterUseCase = itemRegisterUseCase;
    }

    @GetMapping("/items/new")
    public String registerForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "/items/createItemForm";
    }

    @PostMapping("/items/new")
    public String register(@Valid BookForm bookForm, BindingResult bindingResult) {
        RegisterBookCommand registerBookCommand = new RegisterBookCommand(bookForm.getName(), Money.from(bookForm.getPrice()), bookForm.getStockQuantity(), bookForm.getAuthor(), bookForm.getIsbn());
        itemRegisterUseCase.register(registerBookCommand);

        return "redirect:/";
    }
}
