package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.model.form.ProfessorForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorDto modelToDTO(Professor professor);

    Professor dtoToModel(ProfessorDto professorDto);

    Professor formToModel(ProfessorForm professorForm);
}
