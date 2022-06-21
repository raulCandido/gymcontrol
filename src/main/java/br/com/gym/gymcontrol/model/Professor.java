package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    private Long id;

    private String nome;

    private String apelido;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Turma> turmas;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "professor_categoria", joinColumns = {
            @JoinColumn(name = "professor_id")}, inverseJoinColumns = {@JoinColumn(name = "categoria_id")})
    private List<Categoria> categorias;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    public Professor(String nome, String apelido, List<Categoria> categorias) {
        this.nome = nome;
        this.apelido = apelido;
        this.categorias = categorias;
    }

}
