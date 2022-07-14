package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.response.UserRequestDto;
import br.com.gym.gymcontrol.model.dto.response.UserResponseDto;
import br.com.gym.gymcontrol.model.mapper.UsuarioMapper;
import br.com.gym.gymcontrol.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private UserService userService;

    private UsuarioMapper usuarioMapper;

    @Autowired
    public UserController(UserService userService, UsuarioMapper usuarioMapper) {
        this.userService = userService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> authenticate(@RequestHeader Map<String, String> headers, @RequestBody UserRequestDto userRequestDto) {
        Usuario usuario = userService.verifyAndCreateUser(userRequestDto);
        return ResponseEntity.ok(usuarioMapper.modelToResponseDto(usuario));
    }
}

