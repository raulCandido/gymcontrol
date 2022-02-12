package br.com.gym.gymcontrol.error;

import org.springframework.http.HttpStatus;

public enum ApiError {
    ;

    private int code;
    private HttpStatus httpStatus;
    private String description;

    ApiError(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;

    }

}
