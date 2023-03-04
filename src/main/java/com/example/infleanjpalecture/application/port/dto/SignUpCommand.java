package com.example.infleanjpalecture.application.port.in.dto;

import com.example.infleanjpalecture.domain.Address;
import lombok.Getter;

public record SignUpCommand(String memberName, Address address) {

}
