package com.example.infleanjpalecture.member.application.port.dto;

import com.example.infleanjpalecture.common.domain.Address;

public record SignUpCommand(String memberName, Address address) {

}
