package br.com.gym.gymcontrol.model.dto.response;


import java.util.List;


public record ProfessorReponseDto(Long id, String nome, String apelido, List<TurmaResponseDto> turmas,
                                  List<CategoriaResponseDto> categorias) {


}
