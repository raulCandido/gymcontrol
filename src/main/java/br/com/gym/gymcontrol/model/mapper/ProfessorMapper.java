package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorDto toDTO(Professor professor);

    Professor toModel(ProfessorDto professorDto);
}
