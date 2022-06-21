package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.UserRecord;

public interface UserService {

    void findAndCreateUserWithTeacher(UserRecord user);
    void insertUser(Usuario usuario);

}
