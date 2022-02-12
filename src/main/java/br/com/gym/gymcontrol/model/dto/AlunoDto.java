package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Aluno;
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
    private String alcunha;
    private LocalDate dataNascimento;
    private List<TurmaDto> turmasDto;

    public AlunoDto(Aluno aluno) {
        super();
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.alcunha = aluno.getAlcunha();
        this.dataNascimento = aluno.getDataNascimento();
        this.turmasDto = aluno.getTurmas().stream().map(TurmaDto::new).collect(Collectors.toList());
    }

}
