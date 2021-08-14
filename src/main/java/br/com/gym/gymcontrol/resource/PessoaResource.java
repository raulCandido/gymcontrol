package br.com.gym.gymcontrol.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.dto.PessoaDto;
import br.com.gym.gymcontrol.service.PessoaService;

@RestController()
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDto>> getPessoas() {
	List<Pessoa> pessoas = pessoaService.getPessoas();

	List<PessoaDto> PessoasDto = pessoas.stream().map(pessoa -> new PessoaDto(pessoa)).collect(Collectors.toList());

	return ResponseEntity.ok(PessoasDto);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> setPessoas(@Validated @RequestBody PessoaDto pessoaDto,
	    UriComponentsBuilder builder) {
	Pessoa pessoa = pessoaService.inserirPessoa(new Pessoa(pessoaDto.getNome(), pessoaDto.getAlcunha(),
		pessoaDto.getDataNascimento(), pessoaDto.getTipoPessoa()));
	URI uri = builder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
	return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }
}
