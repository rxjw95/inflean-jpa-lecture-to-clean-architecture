package com.example.infleanjpalecture.common.domain;

import com.example.infleanjpalecture.exception.MoneyNegativeException;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Money {
    public static final Money ZERO = new Money(0);

    private int value;

    public Money(int value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public static Money from(int value) {
        return new Money(value);
    }

    public static Money sum(List<Money> moneyList) {
        return new Money(moneyList.stream().mapToInt(Money::toIntValue).sum());
    }

    public int toIntValue() {
        return value;
    }

    public Money multiply(int value) {
        return new Money(this.value * value);
    }

    public Money add(int value) {
        return new Money(this.value + value);
    }

    public Money subtract(int value) {
        int result = this.value - value;
        if(result < 0) {
            throw new MoneyNegativeException();
        }
        return new Money(result);
    }

}
