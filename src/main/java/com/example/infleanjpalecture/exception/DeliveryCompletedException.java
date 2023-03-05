package com.example.infleanjpalecture.exception;

public class DeliveryCompletedException extends RuntimeException {

    public DeliveryCompletedException() {
        super("이미 배송 완료된 주문입니다.");
    }
}
