package com.upgrad.quora.service.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum QuoraErrors {
    USER_NAME_ALREADY_EXISTS("USER_NAME_ALREADY_EXISTS","1001",HttpStatus.BAD_REQUEST,"User name already exists. Please choose another user name"),
    USER_EMAIL_ALREADY_EXISTS("USER_EMAIL_ALREADY_EXISTS","1002",HttpStatus.BAD_REQUEST,"Email already exists. Please register through alternate email id"),
    USER_NOT_REGISTERED("USER_NOT_FOUND","2001",HttpStatus.UNAUTHORIZED,"User has not registered."),
    INCORRECT_PASSWORD("INCORRECT_PASSWORD","2002",HttpStatus.UNAUTHORIZED,"Entered password is not correct. Please enter correct password"),
    USER_NOT_SIGNED_IN("USER_NOT_SIGNED_IN","2003",HttpStatus.CONFLICT,"You are not logged in the system."),
    INVALID_ACCESS_TOKEN("INVALID_ACCESS_TOKEN","3001",HttpStatus.FORBIDDEN,"Access Token is invalid. You are not authorized."),
    EXPIRED_ACCESS_TOKEN("EXPIRED_ACCESS_TOKEN","3002",HttpStatus.FORBIDDEN,"Access Token is expired. Please logout and re-login to the system."),
    NOT_AN_ADMIN("NOT_AN_ADMIN","3003",HttpStatus.FORBIDDEN,"You are not admin user. Hence you are forbidden to perform this operation"),
    USER_NOT_FOUND("USER_NOT_FOUND","4001",HttpStatus.NOT_FOUND,"User does not exist."),
    USER_TO_BE_DELETED_DOES_NOT_EXIST("USER_TO_BE_DELETED_DOES_NOT_EXIST","4002",HttpStatus.NOT_FOUND,"User to be deleted does not exist"),
    NO_QUESTIONS_PRESENT("NO_QUESTIONS_PRESENT","5001",HttpStatus.INTERNAL_SERVER_ERROR,"No questions present in quora");
    @Getter
    private String errorCode;
    @Getter
    private String internalErrorCode;
    @Getter
    private HttpStatus status;
    @Getter
    private String messsage;
}
