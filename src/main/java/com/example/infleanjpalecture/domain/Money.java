package com.example.infleanjpalecture.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {
    public static final Money ZERO = new Money(0);

    private int value;

    public Money(int value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int toIntValue() {
        return value;
    }

}
