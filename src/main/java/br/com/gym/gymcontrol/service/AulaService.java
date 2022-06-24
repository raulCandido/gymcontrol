package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.dto.request.AulaRequestDto;

import java.util.List;

public interface AulaService {
    List<Aula> buscarAulas();
    Aula salvarAula(Aula aula);
    Aula buscarAulaPorId(Long id);
    void deletarAula(Long idAula);
    void buscarEditarAula(Long id, AulaRequestDto aulaRequestDto);
    void buscarDeletarAula(Long id);
    Aula montarAulaParaPersistir(AulaRequestDto aulaRequestDto);


}
