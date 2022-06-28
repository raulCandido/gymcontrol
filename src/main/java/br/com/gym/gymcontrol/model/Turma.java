package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Turma implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turma_id")
    private Long idTurma;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;

    @NotNull
    private LocalTime horarioTurma;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "turma")
    private List<Aula> aulas;

    public Turma(String nome, Categoria categoria, Professor professor) {
        super();
        this.nome = nome;
        this.categoria = categoria;
        this.professor = professor;
    }

    public Turma(Long idTurma, String nome, Categoria categoria) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.categoria = categoria;
    }
}
