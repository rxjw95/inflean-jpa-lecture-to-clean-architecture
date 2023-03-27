package com.example.infleanjpalecture.member.application.dto;

import com.example.infleanjpalecture.common.domain.Address;
import lombok.Getter;

@Getter
public class MemberDto {
    private final String name;
    private final Address address;

    public MemberDto(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
