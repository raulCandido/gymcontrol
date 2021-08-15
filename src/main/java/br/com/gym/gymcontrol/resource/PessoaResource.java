package br.com.gym.gymcontrol.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	List<PessoaDto> pessoasDto = pessoaService.converterPessoasEmPessoasDto(pessoas);
	return ResponseEntity.ok(pessoasDto);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> setPessoas(@Valid @RequestBody PessoaDto pessoaDto, UriComponentsBuilder builder) {
	Pessoa pessoa = pessoaService.inserirPessoa(new Pessoa(pessoaDto.getNome(), pessoaDto.getAlcunha(),
		pessoaDto.getDataNascimento(), pessoaDto.getTipoPessoa()));
	URI uri = builder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
	return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> buscarPessoaPorId(@PathVariable Long id) {
	Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
	PessoaDto pessoaDto = pessoaService.pessoaParaPessoaDto(pessoa);
	return ResponseEntity.ok(pessoaDto);
    }

    @GetMapping(params = "nome")
    public ResponseEntity<List<PessoaDto>> buscarPessoaPorNome(@RequestParam(name = "nome") String nome) {
	List<Pessoa> pessoa = pessoaService.buscarPessoaPorNome(nome);
	List<PessoaDto> pessoasDto = pessoaService.converterPessoasEmPessoasDto(pessoa);
	return ResponseEntity.ok(pessoasDto);
    }
}
