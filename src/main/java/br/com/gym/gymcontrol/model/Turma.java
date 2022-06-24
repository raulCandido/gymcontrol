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
    @Column(name = "idturma")
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Professor professor;

    @ManyToMany(mappedBy = "turmas", fetch = FetchType.LAZY)
    private List<Aluno> alunos;

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

    public Turma(Long id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }
}
