package br.com.gym.gymcontrol.model;

import br.com.gym.gymcontrol.model.dto.response.AlunoResponseDto;
import br.com.gym.gymcontrol.model.dto.response.AulaResponseDto;
import br.com.gym.gymcontrol.model.dto.response.TurmaResponseDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Aula implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaula")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Turma turma;

    @NotNull(message = "Data da aula obrigatória")
    private LocalDate data;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "aula_aluno",
            joinColumns = {@JoinColumn(name = "idaula")},
            inverseJoinColumns = {@JoinColumn(name = "aluno_id")})
    private List<Aluno> alunosPresentes;

    public AulaResponseDto toDto() {
        return new AulaResponseDto(id, new TurmaResponseDto(turma), data, alunosPresentes.stream().map(a -> new AlunoResponseDto(a)).collect(Collectors.toList()));
    }
}
