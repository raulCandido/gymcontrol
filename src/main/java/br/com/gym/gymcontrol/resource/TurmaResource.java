package br.com.gym.gymcontrol.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gym.gymcontrol.model.dto.TurmaDto;
import br.com.gym.gymcontrol.model.form.TurmaForm;
import br.com.gym.gymcontrol.service.TurmaService;

@RestController()
@RequestMapping("/turma")
public class TurmaResource {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaDto> setTurmaService(@RequestBody @Valid TurmaForm turmaForma, UriComponentsBuilder builder) {
	return null;
    }

}
