package br.com.gym.gymcontrol.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessError {
    RESOURCE_NOT_FOUND(1_001, HttpStatus.NOT_FOUND, "Recurso não encontrado."),
    TEACHER_NOT_WITH_CATEGORY(1_002, HttpStatus.INTERNAL_SERVER_ERROR, "Professor nao possui categoria para ser responsabilizado pela turma"),
    TEACHER_LINKED_WITH_CLASS(1_003, HttpStatus.INTERNAL_SERVER_ERROR, "Professor ja vinculado a turma");

    private int code;
    private HttpStatus httpStatus;
    private String description;

    BusinessError(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }

}
