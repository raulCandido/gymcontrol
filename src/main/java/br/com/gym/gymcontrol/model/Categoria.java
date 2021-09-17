package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

}
