package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.AlunoDto;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.model.form.AlunoNewDto;
import br.com.gym.gymcontrol.model.form.ProfessorForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoNewDto modelToNewDto(Aluno aluno);
    Aluno newDtoToModel(AlunoNewDto alunoNewDto);
    AlunoDto modelToDto(Aluno aluno);
}
