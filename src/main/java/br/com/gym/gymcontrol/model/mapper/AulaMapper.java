package br.com.gym.gymcontrol.model.mapper;


import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.dto.response.AulaResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AulaMapper {
    AulaResponseDto modelToResponseDto(Aula aula);
}
