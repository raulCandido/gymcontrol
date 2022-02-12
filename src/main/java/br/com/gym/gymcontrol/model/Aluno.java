package br.com.gym.gymcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    protected Long id;

    protected String nome;

    protected String alcunha;

    protected LocalDate dataNascimento;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aluno_turma", joinColumns = {@JoinColumn(name = "aluno_id")}, inverseJoinColumns = {
            @JoinColumn(name = "turma_id")})
    private List<Turma> turmas;

    public Aluno(String nome, String alcunha, LocalDate dataNascimento, List<Turma> turmas) {
        this.nome = nome;
        this.alcunha = alcunha;
        this.dataNascimento = dataNascimento;
        this.turmas = turmas;
    }

}
