package br.com.gym.gymcontrol.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessorReponseDto {
    private Long id;

    private String nome;

    private String apelido;

    private List<TurmaResponseDto> turmas;

    private List<CategoriaResponseDto> categorias;

}
