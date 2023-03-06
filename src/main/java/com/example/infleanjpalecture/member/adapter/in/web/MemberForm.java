package com.example.infleanjpalecture.member.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    @NotBlank(message = "이름은 필수값입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
