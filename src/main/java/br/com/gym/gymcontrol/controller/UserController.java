package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.dto.response.UserRequestDto;
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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserRequestDto> createUser(@RequestHeader Map<String, String> headers, @RequestBody UserRequestDto user){

        userService.findAndCreateUserWithTeacher(user);

        return ResponseEntity.ok(user);
    }
}

