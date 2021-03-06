package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.dto.request.AlunoRequestDto;
import br.com.gym.gymcontrol.model.dto.response.AlunoResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoRequestDto modelToNewDto(Aluno aluno);
    Aluno newDtoToModel(AlunoRequestDto alunoRequestDto);
    AlunoResponseDto modelToResponseDto(Aluno aluno);
}
