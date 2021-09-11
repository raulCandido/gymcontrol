package br.com.gym.gymcontrol.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Aluno extends Pessoa {

    private static final long serialVersionUID = 1L;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "alunos")
    private List<Turma> turmas;

    public Aluno(String nome, String alcunha, LocalDate dataNascimento, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.alcunha = alcunha;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = tipoPessoa;
    }

}
