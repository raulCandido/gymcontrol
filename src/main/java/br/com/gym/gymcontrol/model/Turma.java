package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "turma")
    private List<Aula> aulas;

    public Turma(String nome, Categoria categoria, Professor professor) {
	super();
	this.nome = nome;
	this.categoria = categoria;
	this.professor = professor;
    }

}
