package com.bichri.Client_Mgr.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
