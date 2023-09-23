package com.go2geda.exception;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Date timeStamp;
}
