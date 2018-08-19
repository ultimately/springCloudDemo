package com.levlin.exception;

public class SignValidException extends Exception {

    public SignValidException(){super("非法请求");}

    public SignValidException(String message){super(message);}
}