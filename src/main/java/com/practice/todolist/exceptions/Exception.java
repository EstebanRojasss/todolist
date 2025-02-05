package com.practice.todolist.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
@EqualsAndHashCode(callSuper = true)
@Data
public class Exception extends RuntimeException{

    private HttpStatus status;
    public Exception(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}

