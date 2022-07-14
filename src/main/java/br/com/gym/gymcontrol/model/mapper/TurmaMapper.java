package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.response.TurmaResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TurmaMapper {
    TurmaResponseDto modelToResponseDto(Turma turma);
}
