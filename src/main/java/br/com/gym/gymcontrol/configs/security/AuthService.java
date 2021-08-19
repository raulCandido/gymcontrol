package br.com.gym.gymcontrol.configs.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.repository.UsuariorRepository;

@Service
public class AuthService implements UserDetailsService{
    
    @Autowired
    private UsuariorRepository usuariorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<Usuario> usuario = usuariorRepository.findByEmail(username);
	return usuario.orElseThrow(() -> new ResourceNotFoundException("E-mail não encontrado."));
    }

}
