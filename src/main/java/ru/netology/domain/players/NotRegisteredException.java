package ru.netology.domain.players;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String msg) {
        super(msg);
    }
}
