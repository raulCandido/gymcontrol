package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.response.UserRequestDto;

public interface UserService {

    void findAndCreateUserWithTeacher(UserRequestDto user);
    void insertUser(Usuario usuario);

}
