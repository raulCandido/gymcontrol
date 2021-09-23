package br.com.gym.gymcontrol.model.dto;

import java.util.List;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessorDto {
    private Long id;

    private String nome;

    private String alcunha;

    private List<Categoria> categorias;

    public ProfessorDto(Professor professor) {
	this.id = professor.getId();
	this.nome = professor.getNome();
	this.alcunha = professor.getAlcunha();
	this.categorias = professor.getCategorias();
    }

    public ProfessorDto(Long id, String nome, String alcunha) {
	super();
	this.id = id;
	this.nome = nome;
	this.alcunha = alcunha;

    }

}
