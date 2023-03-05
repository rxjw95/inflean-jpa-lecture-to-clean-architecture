package com.example.infleanjpalecture.item.application.port.dto;

public record ItemRegisterCommand(String name, int price, int stockQuantity, String author, String isbn) {
}
