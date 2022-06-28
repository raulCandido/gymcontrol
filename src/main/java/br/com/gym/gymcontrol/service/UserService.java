package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.response.UserRequestDto;

public interface UserService {

    Usuario verifyAndCreateUser(UserRequestDto userRequestDto);
    Usuario findUserById(Long id);


}
