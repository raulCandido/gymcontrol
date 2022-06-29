package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Long id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aluno_turma", joinColumns = {@JoinColumn(name = "aluno_id")}, inverseJoinColumns = {
            @JoinColumn(name = "turma_id")})
    @JsonBackReference
    private List<Turma> turmas;

    public Aluno(String nome, String apelido, LocalDate dataNascimento, List<Turma> turmas) {
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.turmas = turmas;
    }

}
