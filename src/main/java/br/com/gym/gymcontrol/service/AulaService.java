package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.dto.AulaDto;
import br.com.gym.gymcontrol.model.form.AlunoNewDto;

import java.util.List;

public interface AulaService {
    List<Aula> buscarAulas();
    Aula salvarAula(Aula aula);
    Aula buscarAulaPorId(Long id);
    void deletarAula(Long idAula);
    void buscarEditarAula(Long id, AulaDto aulaDto);
    void buscarDeletarAula(Long id);
    Aula montarAulaParaPersistir(AulaDto aulaDto);


}
