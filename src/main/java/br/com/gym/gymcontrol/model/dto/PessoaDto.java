package br.com.gym.gymcontrol.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;
    @NotEmpty(message = "Alcunha obrigatório")
    private String alcunha;
    @NotNull(message = "Tipo obrigatório")
    private TipoPessoa tipoPessoa;

    @NotNull(message = "Data de nascimento obrigatório")
    private LocalDate dataNascimento;

    public PessoaDto(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.alcunha = pessoa.getAlcunha();
        this.tipoPessoa = pessoa.getTipoPessoa();
        this.dataNascimento = pessoa.getDataNascimento();
    }

    public static Page<PessoaDto> converterPessoasEmPessoasDto(Page<Pessoa> pessoas) {
        return pessoas.map(PessoaDto::new);
    }

    public static List<PessoaDto> converterPessoasEmPessoasDto(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
    }

}
