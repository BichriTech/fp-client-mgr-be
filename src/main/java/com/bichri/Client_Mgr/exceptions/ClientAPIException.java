package com.bichri.Client_Mgr.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ClientAPIException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;
}
