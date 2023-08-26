package ru.sobse.spring_boot_authorization.exeption;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
