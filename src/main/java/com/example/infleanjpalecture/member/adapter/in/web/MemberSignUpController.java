package com.example.infleanjpalecture.member.adapter.in.web;

import com.example.infleanjpalecture.common.domain.Address;
import com.example.infleanjpalecture.member.application.port.dto.SignUpCommand;
import com.example.infleanjpalecture.member.application.port.in.MemberSignUpUseCase;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberSignUpController {

    private final MemberSignUpUseCase memberSignUpUseCase;

    public MemberSignUpController(MemberSignUpUseCase memberSignUpUseCase) {
        this.memberSignUpUseCase = memberSignUpUseCase;
    }

    @GetMapping("/members/new")
    public String form(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String form(@Valid MemberForm memberForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "members/createMemberForm";
        }

        SignUpCommand command = new SignUpCommand(memberForm.getName(), new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode()));

        memberSignUpUseCase.signUp(command);


        return "redirect:/";
    }

}
