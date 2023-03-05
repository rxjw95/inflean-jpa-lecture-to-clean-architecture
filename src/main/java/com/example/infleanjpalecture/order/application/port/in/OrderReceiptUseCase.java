package com.example.infleanjpalecture.order.application.port.in;

public interface OrderReceiptUseCase {

    Long order(Long memberId, Long itemId, int count);
}
