package br.com.gym.gymcontrol.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
	List<Aluno> alunos = alunoService.buscarAlunos();
	return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> setAlunos() {
	return null;
    }

    @PutMapping
    public ResponseEntity<Aluno> editAlunos() {
	return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletAlunos() {
	return null;
    }
}
