package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.request.ProfessorRequestDto;
import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorReponseDto modelToResponseDto(Professor professor);

    Professor requestDtoToModel(ProfessorRequestDto professorRequestDto);
}
