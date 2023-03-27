package com.example.infleanjpalecture.member.application.dto;

import com.example.infleanjpalecture.common.domain.Address;

public record SignUpCommand(String memberName, Address address) {

}
