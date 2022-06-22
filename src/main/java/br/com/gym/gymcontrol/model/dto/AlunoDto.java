package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Aluno;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

    private Long id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;

    @JsonProperty("turmas")
    private List<TurmaDto> turmasDto;

    public AlunoDto(Aluno aluno) {
        super();
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.apelido = aluno.getApelido();
        this.dataNascimento = aluno.getDataNascimento();
        this.turmasDto = aluno.getTurmas().stream().map(TurmaDto::new).collect(Collectors.toList());
    }

}
