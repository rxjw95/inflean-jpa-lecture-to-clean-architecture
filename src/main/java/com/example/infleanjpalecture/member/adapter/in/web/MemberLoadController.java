package com.example.infleanjpalecture.member.adapter.in.web;

import com.example.infleanjpalecture.member.application.port.dto.MemberDto;
import com.example.infleanjpalecture.member.application.port.in.MemberLoadUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberLoadController {

    private final MemberLoadUseCase memberLoadUseCase;

    public MemberLoadController(MemberLoadUseCase memberLoadUseCase) {
        this.memberLoadUseCase = memberLoadUseCase;
    }

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<MemberDto> memberDtos = memberLoadUseCase.loadAll();
        model.addAttribute("members", memberDtos);
        return "members/memberList";
    }
}
