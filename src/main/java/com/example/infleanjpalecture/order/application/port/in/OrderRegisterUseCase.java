package com.example.infleanjpalecture.order.application.port.in;

public interface OrderRegisterUseCase {

    Long order(Long memberId, Long itemId, int count);
}
