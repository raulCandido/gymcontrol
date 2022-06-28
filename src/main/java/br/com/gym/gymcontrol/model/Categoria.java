package br.com.gym.gymcontrol.model;

import br.com.gym.gymcontrol.model.dto.response.CategoriaResponseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Categoria implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private long id;

    private String nomeCategoria;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "categoria")
    @JsonBackReference
    private List<Turma> turmas;

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public CategoriaResponseDto toDto() {
        return new CategoriaResponseDto(this.id, this.nomeCategoria);
    }
}
