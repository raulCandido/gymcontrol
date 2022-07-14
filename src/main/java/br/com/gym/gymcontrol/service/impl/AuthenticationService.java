package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.repository.UsuariorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    private UsuariorRepository usuariorRepository;
    @Autowired
    public AuthenticationService(UsuariorRepository usuariorRepository) {
        this.usuariorRepository = usuariorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuariorRepository.findByEmail(username);
        return usuario.orElseThrow(() -> new ResourceNotFoundException("Usúario não encontrado."));
    }

}
