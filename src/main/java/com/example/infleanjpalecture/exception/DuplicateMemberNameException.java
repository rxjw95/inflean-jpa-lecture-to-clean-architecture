package com.example.infleanjpalecture.exception;

public class DuplicateMemberNameException extends RuntimeException{

    public DuplicateMemberNameException() {
        super("이미 존재하는 사용자입니다.");
    }
}
