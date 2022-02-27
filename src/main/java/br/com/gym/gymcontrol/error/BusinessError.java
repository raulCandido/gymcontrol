package br.com.gym.gymcontrol.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessError {
    RESOURCE_NOT_FOUND(1_001, HttpStatus.NOT_FOUND, "Recurso não encontrado.");

    private int code;
    private HttpStatus httpStatus;
    private String description;

    BusinessError(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }

}
