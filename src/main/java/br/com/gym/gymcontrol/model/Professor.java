package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    private Long id;

    private String nome;

    private String alcunha;

    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Turma> turmas;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "professor_categoria", joinColumns = {
            @JoinColumn(name = "professor_id")}, inverseJoinColumns = {@JoinColumn(name = "categoria_id")})
    private List<Categoria> categorias;

    public Professor(String nome, String alcunha, List<Categoria> categorias) {
        this.nome = nome;
        this.alcunha = alcunha;
        this.categorias = categorias;
    }

}
