package com.upgrad.quora.service.exception;

import com.upgrad.quora.service.common.QuoraErrors;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * UserNotFoundException is thrown when the user is not found in the database.
 */

@Data
public class UserNotFoundException extends Exception {
    private final String code;
    private final String errorMessage;
    private final HttpStatus status;


    public UserNotFoundException(QuoraErrors error){
        this.code = error.getErrorCode();
        this.errorMessage = error.getMesssage();
        this.status = error.getStatus();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }


}
