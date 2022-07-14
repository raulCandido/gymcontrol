package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Usuario;
import br.com.gym.gymcontrol.model.dto.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UserResponseDto modelToResponseDto(Usuario usuario);
}
