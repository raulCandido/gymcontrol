package br.com.gym.gymcontrol.model.dto.response;

import br.com.gym.gymcontrol.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponseDto {

    private Long id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;

    public AlunoResponseDto(Aluno aluno) {
        super();
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.apelido = aluno.getApelido();
        this.dataNascimento = aluno.getDataNascimento();
    }

}
