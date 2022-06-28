package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.error.BusinessError;
import br.com.gym.gymcontrol.exception.BusinessException;
import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.response.UserRequestDto;
import br.com.gym.gymcontrol.repository.UsuariorRepository;
import br.com.gym.gymcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UsuariorRepository usuariorRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UsuariorRepository usuariorRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuariorRepository = usuariorRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Usuario verifyAndCreateUser(UserRequestDto userRequestDto) {
        Optional<Usuario> user = usuariorRepository.findByEmail(userRequestDto.email());
        if (user.isPresent()) {
            throw new BusinessException(BusinessError.GENERAL_ERROR);
        }
        return usuariorRepository.save(Usuario.builder().email(userRequestDto.email()).senha(bCryptPasswordEncoder.encode(userRequestDto.senha())).build());
    }

    public Usuario findUserById(Long id) {
        return usuariorRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessError.GENERAL_ERROR));
    }

}
