package com.example.infleanjpalecture.member.domain;

import com.example.infleanjpalecture.common.domain.Address;
import com.example.infleanjpalecture.domain.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long memberId;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
