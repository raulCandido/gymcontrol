package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

}
