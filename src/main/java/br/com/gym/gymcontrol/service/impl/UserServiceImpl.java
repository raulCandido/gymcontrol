package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.response.UserRequestDto;
import br.com.gym.gymcontrol.repository.UsuariorRepository;
import br.com.gym.gymcontrol.service.ProfessorService;
import br.com.gym.gymcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private ProfessorService professorService;

    private UsuariorRepository usuariorRepository;

    @Autowired
    public UserServiceImpl(ProfessorService professorService, UsuariorRepository usuariorRepository) {
        this.professorService = professorService;
        this.usuariorRepository = usuariorRepository;
    }

    @Transactional
    @Override
    public void findAndCreateUserWithTeacher(UserRequestDto user) {
        Professor professor = professorService.buscarProfessorPorId(user.idProfessor());
        Usuario usuario = createUserByteacher(user, professor);
        insertUser(usuario);
    }

    private Usuario createUserByteacher(UserRequestDto user, Professor professor){
        return Usuario.builder().email(user.email()).senha(user.senha()).professor(professor).build();
    }

    @Override
    public void insertUser(Usuario usuario){
        usuariorRepository.save(usuario);
    }
}
