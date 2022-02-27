package br.com.gym.gymcontrol.exception;

import br.com.gym.gymcontrol.error.BusinessError;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private BusinessError businessError;

    public BusinessException(BusinessError businessError) {
        this.businessError = businessError;
    }

}
