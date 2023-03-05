package com.example.infleanjpalecture.exception;

public class MoneyNegativeException extends RuntimeException {
    public MoneyNegativeException() {
        super("돈은 음수가 될 수 없습니다.");
    }
}
