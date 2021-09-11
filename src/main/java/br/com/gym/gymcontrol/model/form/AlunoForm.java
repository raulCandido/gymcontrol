package br.com.gym.gymcontrol.model.form;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

	@NotEmpty(message = "Nome obrigatório")
	private String nome;

	@NotEmpty(message = "Alcunha obrigatório")
	private String alcunha;

	@NotNull(message = "Data de nascimento obrigatória")
	private LocalDate dataNascimento;

	@NotNull(message = "Tipo obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	public Aluno converterParaPessoa() {
		return new Aluno(this.nome, this.alcunha, this.dataNascimento, this.tipoPessoa);
	}

}
