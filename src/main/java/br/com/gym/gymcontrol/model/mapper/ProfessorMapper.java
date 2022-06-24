package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;
import br.com.gym.gymcontrol.model.dto.request.ProfessorRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorReponseDto modelToDTO(Professor professor);

    Professor dtoToModel(ProfessorReponseDto professorReponseDto);

    Professor formToModel(ProfessorRequestDto professorRequestDto);
}
