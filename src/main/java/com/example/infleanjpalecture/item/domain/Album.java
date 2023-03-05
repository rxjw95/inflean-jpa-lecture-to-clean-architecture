package com.example.infleanjpalecture.item.domain;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Album extends Item{

    private String artist;
    private String etc;

    public Album(String artist, String etc) {
        this.artist = artist;
        this.etc = etc;
    }

}
